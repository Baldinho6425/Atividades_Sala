import cv2

face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

# Iniciar a  webcam
cap = cv2.VideoCapture(0)

# Inicializar o tracker
tracker = cv2.TrackerCSRT_create()

initialized = False

while True:
    ret, frame = cap.read()
    if not ret:
        break

    # Converter para escala de cinza
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    # Se o tracker não foi inicializado, detectar uma face
    if not initialized:
        faces = face_cascade.detectMultiScale(gray, 1.1, 4)
        if len(faces) > 0:
            # Inicializar o tracker na primeira face detectada
            x, y, w, h = faces[0]
            tracker.init(frame, (x, y, w, h))
            initialized = True
    else:
        # Acompanhar a face detectada
        ret, bbox = tracker.update(frame)
        if ret:
            # Desenhar o retângulo ao redor da face
            x, y, w, h = [int(v) for v in bbox]
            cv2.rectangle(frame, (x, y), (x + w, y + h), (255, 0, 0), 2)
        else:
            # Caso o tracker não consiga seguir a face
            cv2.putText(frame, "Tracking Failed", (20, 20), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 0, 255), 2)

    # Exibir a imagem com o rastreamento da face
    cv2.imshow('Webcam - Acompanhamento da Face', frame)

    # Fechar a janela se pressionar 'q'
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
