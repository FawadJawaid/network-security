# Network Security
This project presents one of the works which I have done in my Network Security course. RSA Exercise, DES Exercise, Obtaining A X.509 Certificate and Buffer Overflow (Ethical Hacking) are done in this project.  


1) **RSA Excercise**    

OpenSSL can be downloaded from http://openssl.org. 

OpenSSL is a full featured encryption toolkit that is used to implement secure services. Using openssl create
a 2048-bit RSA key pair.

Create a directory for this part of the lab. Store your private key as private.key and your public
key as public.key. Create a text file input.txt that contains your full name. Encrypt the text file with your private
key and save it as input.rsa. Turn in your public key and encrypted file, these will be used to verify.

Using OpenSSL extract p, q, n, e,and d from your public-private key pair above. Save these out to
a separate text file.


2) **DES Excercise**     

Tasks:
1. gunzip and Untar ("tar -xf") the file and then run the makefile ("make" on the command line).
2. Encrypt a short message.
3. Hand in your plaintext, cipher key, and cipher text.
 

3) **OBTANING A X.509 CERTIFICATE**

1. Open your Microsoft Outlook
2. Go to Tools
3. Select Options
4. Select Security Tab
5. Click on “Get a Digital ID”
6. Select VeriSign Inc. (http://www.symantec.com/digital-id)
7. Select 60-day free trial option
8. Fill in the form and follow the instructions.
9. You are going to receive an e-mail from VeriSign shortly after submitting the form
10. Install Your certificate
11. Check the details of the certificate (Serial number, issuer name, subject name, Signature algorithm, encryption algorithm and the public key)

SENDING SIGNED MESSAGE

 
12. Go back to your Outlook and In the Tools menu select Options, then the Security tab
13. Click "Add digital signature to outgoing messages", click the "Change Settings" button
14. On the next screen click the "Choose..." button. Select the Digital ID you want to use for signing e-mail in Outlook.
15. You will be asked to send an email to a paticular address during demonstration. Write “NetworkSecurity Lab Assignment” in the subject field of the Mail

4) **Buffer Overflow (Ethical Hacking)** 

You are recommended to do this in Linux 


overflow_example.c
#include <stdio.h>
#include <string.h>
int main(int argc, char *argv[]) {
int value = 5;
char buffer_one[8], buffer_two[8];
strcpy(buffer_one, "one"); /* Put "one" into buffer_one. */
strcpy(buffer_two, "two"); /* Put "two" into buffer_two. */
printf("[BEFORE] buffer_two is at %p and contains \'%s\'\n", buffer_two, buffer_two);
printf("[BEFORE] buffer_one is at %p and contains \'%s\'\n", buffer_one, buffer_one);
printf("[BEFORE] value is at %p and is %d (0x%08x)\n", &value, value, value);
printf("\n[STRCPY] copying %d bytes into buffer_two\n\n", strlen(argv[1]));
strcpy(buffer_two, argv[1]); /* Copy first argument into buffer_two. */
printf("[AFTER] buffer_two is at %p and contains \'%s\'\n", buffer_two, buffer_two);
printf("[AFTER] buffer_one is at %p and contains \'%s\'\n", buffer_one, buffer_one);
printf("[AFTER] value is at %p and is %d (0x%08x)\n", &value, value, value);
}


Execution commands 
gcc -o overflow_example overflow_example.c
./overflow_example 1234567890



Overflow scenario 
./overflow_example AAAAAAAAAAAAAAAAAAAAAAAAAAAAA


