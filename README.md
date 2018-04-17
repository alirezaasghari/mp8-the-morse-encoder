# the-morse-encoder
## Mp8 - The Morse Encoder
The Encoder app provides the /encode endpoint. A post to it carrying a string as payload will return another string that contains the morse encoded string. Internally, the Encoder app delegates the encoding letter by letter to the Morse app, which has an /morse endpoint. A post to this endpoint with a string containing a single letter will return a string containing the corresponding morse code for it. An additional app representing the UI and an integration tester will be provided.
## Mp14 - The Morse encoder UI
Provide an additional application in the Morse Encoder project that will display an HTML page with a form. In this form we will find a text box and a button to post the message to the Encoder Endpoint. Upon receiving the encoded message, we will display it in the same page.
