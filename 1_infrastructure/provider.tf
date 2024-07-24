terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "5.50.0"
    }
  }
}

provider "aws" {
  region = "us-east-1"
  default_tags {
    tags = {
      applicationname = "DevOps Assesment"
      projectname     = "Internal"
      department      = "DevOps"
      client          = "Internal"
      owner           = "Akshunya"
      startdate       = "24-07-2024"
      enddate         = "30-07-2024"
    }
  }
}