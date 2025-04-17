import pandas as pd
import numpy as np
import pickle
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import StandardScaler

# Load dataset (Example: Insurance Charges Dataset. Remove first column index)
df = pd.read_csv("insurance.csv").iloc[:, 1:]
df["sex"] = df["sex"].map({"female": 0, "male": 1})
df["region"] = df["region"].map({"southwest": 0, "southeast": 1, "northeast" : 2, "northwest":3})
df["smoker"] = df["smoker"].map({"yes": 0, "no": 1})

# Features (X) and Target (y)
X = df[["age", "sex", "bmi", "children", "smoker", "region"]]
y = df["charges"]

# Split data into training and testing sets (80% train, 20% test)
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Train Linear Regression Model
model = LinearRegression()
model.fit(X_train, y_train)

# Save model to a .pkl file
with open("model.pkl", "wb") as file:
    pickle.dump(model, file)

print("Model trained and saved as model.pkl!")