import pickle

import pandas as pd

import numpy as np

from flask import Flask, request, render_template
app = Flask(__name__, template_folder='/opt/flask_insurance')

# Load the trained model
model = pickle.load(open("model.pkl", "rb"))

@app.route("/")

def home():
    return render_template("index.html")
 

@app.route("/predict", methods=["POST"])
def predict():
    # Get form data
    age = float(request.form["age"])
    sex = 1 if request.form["sex"] == "male" else 0
    bmi = float(request.form["bmi"])
    children = int(request.form["children"])
    smoker = 1 if request.form["smoker"] == "no" else 0
    region = int(request.form["region"])

    # Prepare features for prediction
    #features = np.array([[age, sex, bmi, children, smoker, region]])
    feature_names = ["age", "sex", "bmi", "children", "smoker", "region"]
    features = pd.DataFrame([[age, sex, bmi, children, smoker, region]], columns=feature_names)

    # Predict charges
    prediction = model.predict(features)

    #  Format to float and 2 decimal places
    formatted_prediction = f"The predicted value is ${round(float(prediction), 2)}"

    return render_template("result.html", prediction=formatted_prediction)
 

if __name__ == "__main__":
    app.run(debug=True,host='0.0.0.0')