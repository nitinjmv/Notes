FROM python:alpine

WORKDIR /app

COPY . .

# This can be overridden from command line e.g. docker run pyhello python test.py
#CMD [ "python", "HelloWorld.py" ] 

# On the other hand this can't be overridden. arguments get ignored e.g. docker run pyhello python test.py
ENTRYPOINT [ "python", "HelloWorld.py" ] 