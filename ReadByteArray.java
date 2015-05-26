byte[] bytes = new byte[1024];

//write data into byte array...

InputStream input = new ByteArrayInputStream(bytes);

//read first byte
int data = input.read();
while(data != -1) {
    //do something with data

    //read next byte
    data = input.read();
}
