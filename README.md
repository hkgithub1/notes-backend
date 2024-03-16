﻿# notes-backend

 Application can be run by $java -jar notes-0.0.1-SNAPSHOT.jar

 Current Deployment:
   -Backend: Docker image running on EC2 instance
   -Frontend: Static website hosting on S3 with domain name registerd on Route 53

 Notes Application
   -Can create and update notes with or without client records linked
   -Can create and update clients

Potential future upgrades:
  -Added backend functionality including searching for all notes of a client
  -Setup a pipeling using GitLab or AWS for CI/CD
  -Use Google Kubernetes Engine for better control over containers
