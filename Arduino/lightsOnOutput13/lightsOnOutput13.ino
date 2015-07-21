void setup() {
  Serial.begin(9600);
  pinMode(13,OUTPUT);
}
void loop()
{
  if (Serial.available())
  {
    char ch = Serial.read();
    if (ch == '0')
    {
      digitalWrite(13, LOW);
      Serial.println("Desliga lampada");
      Serial.println(digitalRead(13));
    }
    if (ch == '1')
    {
      digitalWrite(13, HIGH);
      Serial.println("Liga lampada");
      Serial.println(digitalRead(13));
    }
  }
}
