# mySmartHouse

Arduino based system to control you house from anywhere using a phone app or a web application.
This was a project designed for my Software for Smartphones class and it is just a proof of concept.
It may be improved in the future.

# How does the project work?

The project uses some IoT ( Internet of Things ) concepts to make your house communicates with the internet.
You will have some kind of embedded system ( an Arduino on this project ) attached to your eletrical object (a lamp, on this example )
and it will be possible to communicate with it through phone app or web application. 
As we are turning on a lamp, we don't need to receive anything from the Arduino. So all we do is sending over the internet a signal 
to make the Arduino turn on/off the lamp. But it is possible to make the communication both ways.

# How to run it on my own?

1 - Get a web server running on your Windows computer ( it needs to be Windows, as I made .dll . If you know what you're doing
just read the .dll and make some similar script for Linux )

2 - Download the web application and put on the right place on your web server

3 - Upload the Arduino code to your Arduino

4 - Make the circuit just like the schematic image I uploaded 

5 - Run the Android Studio and open the project. Then, load it on your Android Phone.

6 - You're good to go!
