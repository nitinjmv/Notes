FROM python:3.8-slim
WORKDIR /opt/flask_insurance
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt
COPY . .
RUN python model.py
CMD ["python", "flaskapp.py"]