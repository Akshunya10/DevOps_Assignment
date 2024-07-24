import redis
import pandas as pd
import json
import boto3
import os
from dotenv import load_dotenv

# Load environment variables from .env file
load_dotenv()

# Load environment variables from Lambda environment variables
redis_host = os.getenv('REDIS_HOST')
redis_port = int(os.getenv('REDIS_PORT', 6379))
redis_password = os.getenv('REDIS_PASSWORD', None)
timeout_seconds = 30
data = []

try:
    print(f"Connecting to Redis at {redis_host}:{redis_port} with timeout {timeout_seconds}s")
    r = redis.StrictRedis(
        host=redis_host, 
        port=redis_port, 
        decode_responses=True, 
        password=redis_password, 
        ssl=True)

    # Check connection
    if r.ping():
        print("Connected to Redis.")

    # Fetch all keys
    keys = r.keys('*')

    for key in keys:
        key_type = r.type(key)
        if key_type == 'string':
            value = r.get(key)
        elif key_type == 'list':
            value = r.lrange(key, 0, -1)
        elif key_type == 'set':
            value = list(r.smembers(key))
        elif key_type == 'hash':
            value = r.hgetall(key)
        elif key_type == 'zset':
            value = list(r.zrange(key, 0, -1))
        else:
            value = f"Unsupported type: {key_type}"
        data.append({"key": key, "value": value})

    # Converting list into DataFrame
    df = pd.DataFrame(data)

    # Converting DataFrame to CSV
    csv_filename = '/tmp/redis_data.csv'
    df.to_csv(csv_filename, index=False)
    print(f"\nCSV file saved as '{csv_filename}'.")

    # Converting DataFrame to JSON
    json_filename = '/tmp/redis_data.json'
    with open(json_filename, 'w') as json_file:
        json.dump(data, json_file, indent=4)
    print(f"\nJSON file saved as '{json_filename}'.")

    # Uploading files to S3 using Boto3
    s3_bucket_name = os.getenv('S3_BUCKET_NAME')
    s3_csv_key = 'redis_data.csv'
    s3_json_key = 'redis_data.json'
    s3 = boto3.client('s3')

    s3.upload_file(csv_filename, s3_bucket_name, s3_csv_key)
    s3.upload_file(json_filename, s3_bucket_name, s3_json_key)
    print("Files uploaded to S3 successfully.")

except Exception as e:
    print(f"Error: {str(e)}")