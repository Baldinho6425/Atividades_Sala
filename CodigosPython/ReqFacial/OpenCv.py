import cv2

# Carregar o classificador Haar Cascade
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

# Iniciar a captura de vídeo
cap = cv2.VideoCapture(0)

while True:
    # Capturar quadro por quadro
    ret, frame = cap.read()
    
    # Converter para escala de cinza
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    
    # Detectar faces
    faces = face_cascade.detectMultiScale(gray, 1.1, 4)
    
    # Desenhar retângulos ao redor das faces
    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x+w, y+h), (255, 0, 0), 2)
    
    # Mostrar o vídeo
    cv2.imshow('Face Detection', frame)
    
    # Sair do loop se pressionar 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
