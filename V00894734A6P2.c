/* Name: Victor Sun
 * UVicID: V00894734
 * Date: 2017/11/21
 * Assignment: A6
 * File name: V00894734A6P2
 * Description: This program Capitalize some stuff
 */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

void read_and_capitalize(){
    int ch;
    ch = getchar();
    if (islower(ch)){
        printf("%c", toupper(ch));
    }
    else if(isdigit(ch)){
        printf("%c", ch);
    }
    else if (isalpha(ch)){
        printf("%c", ch);
    }
    while (isspace(ch)) {
        ch = getchar();
        if (islower(ch)) {
            printf("%c", toupper(ch));
            //ch = getchar();
            break;
        }
        else if (isalpha(ch)) {
            printf("%c", ch);
            break;
        }
        else if(isdigit(ch)){
            printf("%c", ch);
        }

    }
    if(isalpha(ch) == 0 && isdigit(ch) == 0 && isspace(ch) == 0 && islower(ch) == 0 ){
        printf("%c", ch);
    }
    ch = getchar();
    while(ch != '\n'){
        if ( isspace(ch) ) {
            ch = getchar();
            if (islower(ch)) {
                printf(" ");
                printf("%c", toupper(ch));
                ch = getchar();
                continue;
            } else if (isalpha(ch)) {
                printf(" ");
                printf("%c", ch);
                ch = getchar();
                continue;
            }
            else if(isdigit(ch)){
                printf(" ");
                printf("%c", ch);
                ch = getchar();
                continue;
            }
            else if(isalpha(ch) == 0 && isdigit(ch) == 0 && isspace(ch) == 0 && islower(ch) == 0 ){
                printf(" ");
                printf("%c", ch);
                ch = getchar();
                continue;
            }
            continue;
        }
        else if (isalpha(ch)) {
            printf("%c", tolower(ch));
        }
        //else if (isdigit(ch)){
          //printf("%c", ch);
        //}
        else {
            printf("%c", ch);
        }/*if*/
        ch = getchar();
        //Get the next character from the user
    }/*while*/
    printf("\n");
}/*read_and_capitalize*/

int main(void){
    printf("Enter a line of text: ");
    fflush(stdout);
    read_and_capitalize();
    return EXIT_SUCCESS;
}/*if(islower(ch)) {
        printf("%c", toupper(ch));
        ch = getchar();
    }
    if(isdigit(ch)){
        printf("%c", ch);
        ch = getchar();
    }
    else{
        printf("%c", ch);
        ch = getchar();
    }main*/