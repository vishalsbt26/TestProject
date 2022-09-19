FROM ubuntu

COPY . .
EXPOSE 8000
CMD ["test","pom.xml","runserver","0.0.0.0:8000"]