package edu.umsl;
import java.util.Scanner;
import java.util.Base64;
//https://docs.oracle.com/javase/8/docs/api/java/util/Base64.html

public class Conversion {
    public static void main(String[] args)
    {
        //given encoded string that we need to decode
        String encodedString = "SSBsb3ZlIG15IENNUCBTQ0kgMjI2MSBjbGFzcyBzbyBtdWNoLCBJIHdpc2ggSSBjb3VsZCBiZSBqdXN0IGFzIGNvb2wgYXMgbXkgcHJvZmVzc29y";

        //decoding string
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);

        //converting bytes into printable string
        String decodedString = new String(decodedBytes);

        //printing decoded string
        System.out.println("Decoded String: " + decodedString);

        //taking in string for encoding & storing
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a valid string for encoding: ");
        String rawInput = input.nextLine();

        //encoding & printing string
        String finalEncode = Base64.getEncoder().encodeToString(rawInput.getBytes());
        System.out.println("Encoded String: " + finalEncode);

    }
}
