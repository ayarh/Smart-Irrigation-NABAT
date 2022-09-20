#include <dht.h>
#include <Servo.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>
//----- Adressage matériel -----
// En cas de non fonctionnement, mettez la ligne 8 en
// commentaire et retirez le commentaire à la ligne 9.
LiquidCrystal_I2C lcd(0x27, 20, 4);
//LiquidCrystal_I2C lcd(0x3F,20,4);
dht DHT;
int respin = A3;
const int buzzer = 7; 
int ldr=4;
#define DHT11_PIN 6
#define LEDR 1
#define LEDJ 2
#define LEDV 3
Servo myservo;
void setup(){
  pinMode(8, OUTPUT);
  Serial.begin(9600);
  pinMode(A0, INPUT_PULLUP);
  pinMode(4,INPUT);
  //myservo.attach(8); 
  lcd.begin(); // initialisation de l'afficheur 
}

void loop(){
  int chk = DHT.read11(DHT11_PIN);
  int A=(int)DHT.temperature;
  int B=(int)DHT.humidity;
  int m= (int)analogRead(A0);
  int C = analogRead(respin); 
  int D =(int)digitalRead(4);
  Serial.println((String)A+"::"+(String)B+"::"+(String)C+"::"+(String)m);
  delay(3000);
  if(m<=100){
    tone(buzzer, 1000); 
    digitalWrite(LEDR,HIGH);
  delay(1000); 
  }
  else if (m>200 && m<=400){
    digitalWrite(LEDV,HIGH);
  delay(500);
     noTone(buzzer); 
  delay(1000);
}
else if (m>120 && m<=200){
    digitalWrite(LEDJ,HIGH);
  delay(500);
     noTone(buzzer); 
  delay(1000);
}
  char text = Serial.read();
  if (text == '1'){
   // myservo.write(178)
   digitalWrite(8,HIGH);
  }
  else if (text == '0'){
    //myservo.write(3);
     digitalWrite(8,LOW);    
  }
  lcd.backlight();
 // Envoi du message
 lcd.setCursor(0, 0);
 lcd.print("     SMART");
 lcd.setCursor(0,1);
 lcd.print("   IRRIGATION");
}
