# spring_speech_to_text_app
This application use Google's Speech To Text API to create transcription from sound recorded by users microphone.
It is designed to run on Google Cloud App Engine.

Recorded sound is converted to mp3 and sent with AJAX to server.
Servers response contains transcription and level of transcriptions confidence, which is a number between 0 and 1.

Transcription can be easily copied to clipboard by clicking the button.