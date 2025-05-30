import pandas as pd
import numpy as np
from sklearn.ensemble import RandomForestClassifier
from sklearn.model_selection import train_test_split, cross_val_score
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
from imblearn.over_sampling import SMOTE
from sklearn.preprocessing import LabelEncoder

# Simulação de um dataset baseado no artigo
np.random.seed(42)
n = 1570
data = pd.DataFrame({
    'idade': np.random.choice([0, 1], size=n),  # 0: <50, 1: >=50
    'quimio': np.random.choice([0, 1], size=n),
    'linfonodos': np.random.choice([0, 1], size=n),
    'receptor_estrogenio': np.random.choice([0, 1], size=n),
    'receptor_progesterona': np.random.choice([0, 1], size=n),
    'HER2': np.random.choice([0, 1], size=n),
    'subtipo': np.random.choice(['Luminal', 'HER2 Positivo', 'Triplo Negativo'], size=n),
    'sobreviveu': np.random.choice([0, 1], size=n, p=[0.1, 0.9])  # desbalanceado
})

# Codificação de variáveis categóricas
le = LabelEncoder()
data['subtipo'] = le.fit_transform(data['subtipo'])

# Separando variáveis independentes e alvo
X = data.drop('sobreviveu', axis=1)
y = data['sobreviveu']

# Aplicando SMOTE para balancear
smote = SMOTE()
X_resampled, y_resampled = smote.fit_resample(X, y)

# Dividindo em treino e teste
X_train, X_test, y_train, y_test = train_test_split(X_resampled, y_resampled, test_size=0.2, random_state=42)

# Modelo Random Forest
model = RandomForestClassifier(n_estimators=100, random_state=42)
model.fit(X_train, y_train)

# Avaliação
y_pred = model.predict(X_test)
print("Acurácia:", accuracy_score(y_test, y_pred))
print("\nRelatório de Classificação:\n", classification_report(y_test, y_pred))
print("\nMatriz de Confusão:\n", confusion_matrix(y_test, y_pred))
