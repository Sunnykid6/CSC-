/* Name: Victor Sun
 * UVicID: V00894734
 * Date: 2017/11/21
 * Assignment: A6
 * File name: V00894734A6P1
 * Description: This program scrambles some words
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>
#include <string.h>
#include <time.h>
#define BIGLINE (500)
#define INPUT_FILENAME    ("A6P1TestingSherlock.txt")
#define OUTPUT_FILENAME   ("A6P1SherlockEncoded.txt")
void processFile(FILE*, FILE*);
void processLine(char*, FILE*);
void wordScrambler (char*);
FILE* openFile(char*);
FILE* createFile(char*);

void processLine (char *line, FILE* ofp){
    char word[BIGLINE];
    int wordcount = 0;
    int place;
    sscanf(line, "%s%n", word, &place);
    while (*word && place <= strnlen(line, BIGLINE)){
        if (strlen(word) > 3){
            wordScrambler(word);
        }
        fputs(word, ofp);
        if (wordcount > 50) {
            fputs("\n", stdout);
            wordcount = 0;
        }
        fputs(" ", ofp);
        int temp = place;
        sscanf(line + place, "%s%n", word, &place);
        place = place + temp;
    }
    fputs("\n", ofp);
}

void wordScrambler(char *word){
    char temp = word[1];
    char test;
    while (temp == word[1])
    {
        int rand1 = (1 + (rand() % (strlen(word) - 2)));
        int rand2 = (1 + (rand() % (strlen(word) - 2)));
        test = word[rand1];
        word[rand1] = word[rand2];
        word[rand2] = test;
    }
}

void processFile(FILE* ifp, FILE* ofp) {
    char line[BIGLINE];
    printf("Begin file processing\n");
    while (fgets(line, BIGLINE, ifp) != NULL){
        processLine(line, ofp);
    }
    printf("\nEnd file processing\n");
}

FILE* openFile(char* fnam) {
    FILE* ifp = fopen(fnam, "r");
    if (ifp == NULL) {
        printf("Cannot open input file %s\n", fnam);
        exit(EXIT_FAILURE);
    }
    return ifp;
}

FILE* createFile(char* fnam) {
    FILE* ofp = fopen(fnam, "w");
    if (ofp == NULL) {
        printf("Cannot create output file %s\n", fnam);
        exit(EXIT_FAILURE);
    }
    return ofp;
}

int main(void) {
    printf("Starting text encoding...\n\n");
    unsigned int seed = (unsigned int)time(NULL);
    srand(seed);
    FILE* ifp = openFile(INPUT_FILENAME);
    FILE* ofp = createFile(OUTPUT_FILENAME);

    processFile(ifp, ofp);

    fclose(ofp);
    fclose(ifp);
    printf("\nEncoding finished\n");
    return EXIT_SUCCESS;
}
