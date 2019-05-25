/* Name: Victor Sun
 * UVicID: V00894734
 * Date: Dec. 3, 2017
 * Assignment: A7
 * Filename: V00894734A7
 * Description: This program represents a CSC 111 retrospective
 */

#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include <stdbool.h>
#define PASCAL_MAX 100
#define MATRIX_MAX 100
#define MAX_LINE 4096
#define NOT_FOUND (-1)

// prototypes
void testRoman(); //Test Task 1 (Roman Numerals)
void testInvertCase(); //Test Task 2 (Invert Capitalization)
void testMaxFibonacci(); //Test Task 3 (Fibonacci Numbers)
void testLinearSearch(); //Test Task 4 (Linear Search)
void testPascal(); //Test Task 5 (Pascal's Triangle)*/
void testShiftColumnsRight(); //Test Task 6 (Shift Columns Right)
void testStringLength(); //Test Task 7 (String Length)
void testCopySuffix(); //Test Task 8 (Copy Suffix)
void testMirrorString(); //Test Task 9 (Mirror String)
void testDecrypt(); //Test Task 10 (Decrypt)
void testIsPalindrome(); // Test Task 11 (Is Palindrome)
void testRemoveVowels(); // Test Task 12 (Remove Vowels)
void testDBP(); //Test Task 13 (Distance Between Points)
void testCNP(); // Test Task 14 (Count Nearby Points)
void testAddPointAtEnd(); // Test Task 15 (Add Point at End)

int main(void){
    // test incrementally one function at a time
    // comment out the functions you are not working on
    testRoman(); //Test Task 1 (Roman Numerals)
    testInvertCase(); //Test Task 2 (Invert Capitalization)
    testMaxFibonacci(); //Test Task 3 (Fibonacci Numbers)
    testLinearSearch(); //Test Task 4 (Linear Search)
    testPascal(); //Test Task 5 (Pascal's Triangle)*/
    testShiftColumnsRight(); //Test Task 6 (Shift Columns Right)
    testStringLength(); //Test Task 7 (String Length)
    testCopySuffix(); //Test Task 8 (Copy Suffix)
    testMirrorString(); //Test Task 9 (Mirror String)
    testDecrypt(); //Test Task 10 (Decrypt)
    testIsPalindrome(); // Test Task 11 (Is Palindrome)
    testRemoveVowels(); // Test Task 12 (Remove Vowels)
    testDBP(); //Test Task 13 (Distance Between Points)
    testCNP(); // Test Task 14 (Count Nearby Points)
    testAddPointAtEnd(); // Test Task 15 (Add Point at End)
    printf(" ****** Testing Finished ******\n");
    return EXIT_SUCCESS;
}/*main*/

/* ========================================================================= */
/*                              Type Definitions                             */
/*          Do not alter the provided definitions (they will be used         */
/*            for marking). You may add new definitions as needed.           */
/* ========================================================================= */


typedef int Matrix[MATRIX_MAX][MATRIX_MAX];

typedef struct {
    float x, y;
} Point;

/* PointListNode -- A node of a singly-linked list of points */
typedef struct PointListNode{
    Point *p;
    struct PointListNode *next;
} PointListNode;


/* ========================================================================= */
/*                                 Functions                                 */
/*        Do not change the name, return type or parameter types of          */
/*            the functions below or they will not be marked.                */
/*                  You may add new functions as needed.                     */
/* ========================================================================= */

/* ==================================================
   Task 1 - Text Parsing Exercise (easy)
   Roman Numeral to Integer converter
   Parameters:
     s - A null-terminated string containing Roman Numerals.
         No subtractive notation is used, so '9' is represented as 'VIIII'.
         The only characters in s will be 'M','D','C','L','X','V' and 'I'
   Return Value:
     The positive integer value corresponding to the roman numeral
     representation. Note that if the input string is empty (i.e. ""), the
     return value should be zero.
   ==================================================
*/
int roman_to_int(char *s){
    int n = 0;
    for (int i = 0; i < strlen(s); i++) {
        if (s[i] == 'I') n += 1;
        if (s[i] == 'V') n += 5;
        if (s[i] == 'X') n += 10;
        if (s[i] == 'L') n += 50;
        if (s[i] == 'C') n += 100;
        if (s[i] == 'D') n += 500;
        if (s[i] == 'M') n += 1000;
    }

    return n;
} /* roman_to_int */

/* ==================================================
   Task 2 - String Manipulation Exercise (easy)
   Invert the capitalization of a string
   Parameters:
    s - A null-terminated character string.
   Return Value:
    None.
   Result:
    The function should convert every lowercase character in the string s to
    uppercase, and every uppercase character to lowercase (and store the
    modified character back into s). Characters which are not uppercase
    or lowercase letters must be left as-is. For example, if the input string
    is "Csc111", this function would convert it to "cSC111". The standard
    library functions 'islower', 'isupper', 'tolower' and 'toupper' may be
    helpful for this.
   ==================================================
*/
void invert_case(char *s){

    for (int i = 0; i < strlen(s); i++) {
        if (isupper(s[i])) s[i] = tolower(s[i]);
        else s[i] = toupper(s[i]);
    }

} /* invert_case */

/* ==================================================
   Task 3 - Fibonacci excercise (easy)
   Find the largest Fibonacci number below a given limit.
   The Fibonacci sequence is 1, 1, 2, 3, 5, 8, 13, ...
   The first two values are 1, and each subsequent value is the sum of the
   previous two values. This function should return the largest element in the
   sequence smaller than a provided limit.

   For example, max_fibonacci(10) would return 8.

   Parameters:
    upper_limit - The upper limit
   Return Value:
    The largest Fibonacci number less than or equal to upper_limit.
   ==================================================
*/
int max_fibonacci(int max) {

    int a = 1;
    int b = 1;
    int c = 1;
    int cb = 0;
    for (int i = 0; c < max; i++) {
        cb = c;
        if (i > 1) {
            c = a + b;
            a = b;
            b = c;
        }
    }

    return cb;
} /* max_fibonacci */

/* ==================================================
   Task 4 - 1-dimensional Array Exercise (easy)
   Linear Search
   Parameters:
     A - An array of integers
     n - The length of A
     k - An integer to search for in A
   Return Value:
     If k is an element of A, the return value should be an integer i such that
     A[i] == k. If k is not an element of A, the return value should be the
     constant NOT_FOUND (which is defined at the top of this file to be -1).
   ==================================================
*/
int linear_search(int A[], int n, int k){

    for (int i = 0; i < n; i++) {
        if (A[i] == k) {
            return i;
            break;
        }
    }

    return NOT_FOUND;
} /* linear_search */

/* ==================================================
   Task 5 - 2-dimensional Array Exercise I (intermediate)
   Pascal's Triangle
   Parameters:
     A - A 2d array of integers
     n - The number of rows to compute
   Return Value:
     None
   Result:
     When the function completes, the first n rows of A must contain the
     first n rows of Pascal's triangle.
     The first 5 rows of Pascal's triangle are
     1
     1 1
     1 2 1
     1 3 3 1
     1 4 6 4 1

     In general, row k has k + 1 entries, and the first and last entry of each
     row is 1. Every other entry is the sum of the element above, and the
     element above and to the left.
     As the above example shows, row 0 should be "1", row 1 is "1 1", row 2 is
     "1 2 1", etc.

     No more than n rows should be computed. The input array will be guaranteed
     to be large enough to hold all of the values.
   ==================================================
*/
void pascals_triangle(int A[PASCAL_MAX][PASCAL_MAX], int n){

    //A[rows][columns]

    for (int i = 0; i < n; i++) { //columns
        for (int j = 0; j < n; j++) {
            if (i == 0 || j == i || j == 0) {
                A[j][i] = 1;
            }
            else {
                A[j][i] = A[j - 1][i] + A[j - 1][i - 1];
            }
        }
    }
} /* pascals_triangle */



/* ==================================================
   Task 6 - 2-dimensional Array Exercise II (hard)
   Shift a matrix one column to the right.
   Parameters:
    M - A Matrix
    rows - The number of rows in M
    cols - The number of columns in M
   Return Value:
     None
   Result:
     When the function completes, the columns of M will have been shifted
     by one column to the right. For example, if M is a 3 x 4 matrix with
     initial value
        0  1  2  3
       10 11 12 13
       14 15 16 17
     then the value of M after the function completes should be
        3  0  1  2
        13 10 11 12
        17 14 15 16

   ==================================================
*/
void shift_columns_right(Matrix M, int rows, int cols) {

    //A[rows][columns]

    for (int i = 0; i < rows; i++) { //rows
        int end = M[i][cols - 1];
        for (int j = 0; j < cols; j++) {
            M[i][cols - j] = M[i][(cols - j) - 1];
        }
        M[i][0] = end;
    }

} /* shift_columns_right */

/* ==================================================
   Task 7 - String Exercise I (easy)
   Compute the length of the provided string.

   Parameters:
    inputString - A string
   Return Value:
    The length of inputString. In this context, the length of a string is the
    number of characters before the null terminator. For example, the length
    of the string "CSC111" is 6.

    The strlen() function (and its derivatives) may not be used in this
    function.
   ==================================================
*/

int string_length(char inputString[]) {

    int n = 0;
    while (inputString[n] != '\0') {
        n += 1;
    }

    return n;
}

/* ==================================================
   Task 8 - String Exercise II (easy)
   Copy a suffix of inputString to outputString.

   Parameters:
    inputString - The input string
    outputString - An array to store the output string
    start_position - The first index of the inputString to copy
   Return Value:
    None
   Result:
    Every character of inputString from the index start_position to the end
    of the string is copied to the string outputString.

    For example, if inputString is "Hello World" and start_position is 4,
    outputString will be set to the string "o World".
   ==================================================
*/

void copy_suffix(char inputString[], char outputString[], int start_position){

    int i = start_position;
    int n = 0;
    while (inputString[i] != '\0') {
        outputString[n] = inputString[i];
        n += 1;
        i += 1;
    }

    inputString[n] = '\0';

}

/* ==================================================
   Task 9 - String Exercise III (intermediate)
   "Mirror" a string by concatenating it with a reversed copy of itself.
   For example, the string "Hello" would become "HelloolleH" and the string
   "Assignment 8" would become "Assignment 88 tnemngissA"

   Parameters:
    str - The string to mirror
   Return Value:
    None
   Result:
    A reversed copy of the string str will be appended to the end of str.
    You may assume that there is enough space available in str to permit this.
   ==================================================
*/
void mirror_string(char string[]) {



    int len = strlen(string);
    int string_temp[2*len];
    for (int i = 0; i < len; i++) {
        string_temp[i] = string[i];
    }
    int k = 0;
    for (int j = len; j < 2*len; j++) {
        string_temp[j] = string[len - k - 1];
        k += 1;
    }

    int l;

    for (l = 0; l < 2*len; l++) {
        string[l] = string_temp[l];
    }

    string[l] = '\0';

}



/* ==================================================
   Task 10 - String Exercise IV (hard)
   Decrypt a coded message.

   A 'Caesar cipher' is a simple (and very easy to break) encryption method
   where each letter is shifted by one (so 'a' becomes 'b', 'b' becomes 'c'
   and so on, with 'z' becoming 'a'). This function will take a coded
   message and decrypt it to reveal the original message. Every character
   in the message will be a lowercase letter.

   For example, the string 'fohjoffsjoh' would be decrypted to 'engineering'.

   Hint: A char variable c which contains a lowercase letter can be converted
   into a number between 0 and 25 with the expression (c - 'a') and a number
   j between 0 and 25 can be converted to a lowercase letter with the
   expression (j + 'a').

   Parameters:
    codedMessage - A string containing the encrypted message.
    decodedMessage - An array to store the decoded message
   Return Value:
    None
   Result:
    The array decodedMessage will be set to a string containing the decoded
    message.
   ==================================================
*/
void decrypt(char codedMessage[], char decodedMessage[]) {
    int decoded[strlen(codedMessage)];
    for (int i = 0; i < strlen(codedMessage); i++) {
        if (codedMessage[i] == 'z') {
            decoded[i] = ('a' - 'a');
        }
        else if (codedMessage[i] == 'a') {
            decoded[i] = ('z' - 'a');
        }

        else decoded[i] = (codedMessage[i] - 'a') - 1;
    }

    int i;

    for (i = 0; i < strlen(codedMessage); i++) {
        decodedMessage[i] = decoded[i] + 'a';
        //printf("%c", decodedMessage[i]);
    }

    codedMessage = NULL;
    decodedMessage[i] = '\0';

}

/* ==================================================
   Task 11 - String Exercise VI (intermediate)
   Test whether a string is a palindrome, which is a sequence
   which is the same forwards or backwards. For example,
   the strings "racecar" and "hannah" are palindromes. For this
   question, strings are case sensitive, so "Hannah" is not
   considered a palindrome.

   Parameters:
    inputString - A string

   Result:
    Returns true if the string is a palindrome, and false if it is not
	a palindrome
   ==================================================
*/
bool is_palindrome(char inputString[]) {

    int n = 0;
    int len = 0;
    if (strlen(inputString) % 2) {
        len = (strlen(inputString) - 1)/2;
    }
    else len = strlen(inputString)/2;
    for (int i = 0; i < len; i++) {
        if (inputString[i] == inputString[strlen(inputString) - i - 1]) {
            n += 1;
        }
    }
    if (n == len) {
        return true;
    }
    else return false;
}

/* ==================================================
   Task 12 - String Exercise VII (intermediate)
    Remove all vowels (A,a,E,e,I,i,O,o,U,u) from a string
   Parameters:
    inputString - The input string
    outputString - An array to store the output string
   Result:
    The characters in inputString, excluding all vowels, are copied into
	outputString. For example, if inputString is "Shoeless Joe Jackson",
	the contents of outputString will be "Shlss J Jcksn".
   ==================================================
*/
void remove_vowels(char inputString[], char outputString[]){

    int len1 = strlen(inputString);
    int useless = 0;
    int n = 0;
    int i;
    for (i = 0; i < len1; i++) {
        if (inputString[i] == 'A' || inputString[i] == 'a' || inputString[i] == 'E' || inputString[i] == 'e' || inputString[i] == 'I' || inputString[i] == 'i' || inputString[i] == 'O' || inputString[i] == 'o' || inputString[i] == 'U' || inputString[i] == 'u') {
            useless += 1;
        }
        else {
            outputString[n] = inputString[i];
            n += 1;
        }
    }

    outputString[n] = '\0';
}

/* ==================================================
   Task 13 - Struct Exercise (very easy)
   Distance between points in the plane.
   Parameters:
    p1, p2 - Pointers to Point structs (see definition above)
   Return Value:
    The distance between the points described by p1 and p2.
    Note that the distance between points (x1,y1) and (x2,y2) is the
    length of the vector (x1-x2,y1-y2)
   ==================================================
*/
float dist_between_points(Point *p1, Point *p2){

    float cx = p1->x - p2->x;
    float cy = p1->y- p2->y;

    float dis = sqrt((cx*cx) + (cy*cy));

    return dis;
} /* dist_between_points */

/* ==================================================
   Task 14 - Linked List Exercise I (intermediate)
   Count nearby points.
   Parameters:
    pointList - Pointer to the head of a singly-linked list of points (see
                definition above).
    centrePoint - Pointer to a point struct.
    radius - A positive real value.
   Return Value:
    The number of points in pList whose distance from centrePoint is less than
    or equal to the radius provided.
    To obtain the distance, the dist_between_points function from Task 11 can be
    used. The end of the linked list is indicated by the 'next' pointer being
    NULL.
   ==================================================
*/
int count_nearby_points(PointListNode *pointList, Point* centrePoint, float radius){

    int n = 0;
    while (pointList != NULL) {
        if (radius > dist_between_points(pointList->p, centrePoint)) {
            n += 1;
        }
        pointList = pointList->next;
    }
    return n;

} /* count_nearby_points */

/* ==================================================
   Task 15 - Linked List Exercise II (hard)
   Add a point to the end of a linked list of points.
   Parameters:
    pointList - Pointer to the head of a singly-linked list of points (see
                definition above). The list will contain at least one
                node.
    newPoint - Pointer to a Point struct to add to the end of the list.

   Result:
    A new PointListNode referring to newPoint will be placed at the end
    of the provided linked list. Note that the PointListNode must be allocated
    with malloc().

    typedef struct {
        float x, y;
    } Point;

    PointListNode -- A node of a singly-linked list of points
    typedef struct PointListNode{
        Point *p;
        struct PointListNode *next;
    } PointListNode;

   ==================================================
*/
void add_point_at_end(PointListNode *pointList, Point* newPoint){

    PointListNode *newNode = (PointListNode*)malloc(sizeof(PointListNode));
    newNode->p = newPoint;
    newNode->p->x = newPoint->x;
    newNode->p->y = newPoint->y;
    newNode->next = NULL;


    PointListNode *current = pointList;
    while (current->next != NULL) {
        current = current->next;
    }
    current->next = newNode;

} /* add_point_at_end */




/* ========================================================================= */
/*                              Testing Code                                 */
/*        None of the functions in this section will be marked, but          */
/*     they may be useful for testing (you may modify them if you wish)      */
/* ========================================================================= */

/* allocateNewPoint - Allocate memory for a new point, set it to the values provided and return a pointer */
Point *allocateNewPoint(float x,float y){
    Point *p = malloc(sizeof(*p));
    p->x = x;
    p->y = y;
    return p;
} /* allocateNewPoint */

/* addPointToList - Add a new node to the front of a singly linked list, referencing the given point */
PointListNode *addPointToList(PointListNode *list, Point* newPoint){
    PointListNode *newNode = malloc(sizeof(*newNode));
    newNode->next = list;
    newNode->p = newPoint;
    return newNode;
} /* addPointToList */

/* freePointList - Recursively delete a linked list of points */
void freePointList(PointListNode *list){
    if (!list)
        return;
    freePointList(list->next);
    free(list->p);
    free(list);
} /* freePointList */

/* printPointList - Recursively print a linked list of points in reverse order */
void printPointList(PointListNode* list){
    if (!list)
        return;
    printf("(%.2f,%.2f) ",list->p->x,list->p->y);
    printPointList(list->next);
} /* printPointList */

/* reversePointList - Reverse the order of a linked list of points and return the new head */
PointListNode* reversePointList(PointListNode *list){
    if (!list || !list->next)
        return list;
    PointListNode* newPrev = list->next;
    PointListNode* newHead = reversePointList(newPrev);
    newPrev->next = list;
    list->next = NULL;
    return newHead;
} /* reversePointList */

/* firstNonWhitespaceCharacter - Return a pointer to the first non-whitespace character in the string provided */
char *firstNonWhitespaceCharacter(char *s){
    if (!s || !*s)
        return s;
    while (*s == ' ' || *s == '\n' || *s == '\t')
        s++;
    return s;
} /* firstNonWhitespaceCharacter */

/* removeTrailingSpaces - If the string s contains spaces at the end, get rid of them (e.g. "abcd   " would become "abcd" */
void removeTrailingSpaces(char *s){
    char* lastNonSpace = s;
    while (*s){
        if (*s != ' ' && *s != '\n' && *s != '\t')
            lastNonSpace = s;
        s++;
    }
    while (lastNonSpace != s)
        *++lastNonSpace = '\0';
}

/* readNInts - Read up to n integers from the input string provided and return the number read. */
int readNInts(char* input, int out[], int n){
    int i;
    long val;
    for (i = 0; i < n; i++){
        //Advance the input pointer until we find the beginning of an integer
        //(that is, a digit or a - sign)
        while (*input && !isdigit(*input) && *input != '-')
            input++;
        if (!*input)
            break;
        /* Use strtol to read a long integer in base 10 from the current position of input,
           and then store the location of the first character after the number it read
           back into the input pointer (so we can move on to the next value) */
        val = strtol(input,&input,10);
        //Since val is declared as long, we have to cast it back to int
        out[i] = (int)val;
    }
    return i;
} /* readNInts */

/* readNFloats - Read up to n floats from the input string provided and return the number read. */
int readNFloats(char* input, float out[], int n){
    int i;
    float val;
    for (i = 0; i < n; i++){
        //Advance the input pointer until we find the beginning of a number
        //(that is, a digit, a decimal point or a '-' sign)
        while (*input && !isdigit(*input) && *input != '-' && *input != '.')
            input++;
        if (!*input)
            break;
        /* Use strtof to read a floating-point value from the current position of input,
           and then store the location of the first character after the number it read
           back into the input pointer (so we can move on to the next value) */
        val = strtof(input,&input);
        out[i] = val;
    }
    return i;
} /* readNFloats */

/* readNDoubles - Read up to n doubles from the input string provided and return the number read. */
int readNDoubles(char* input, double out[], int n){
    int i;
    double val;
    for (i = 0; i < n; i++){
        //Advance the input pointer until we find the beginning of a number
        //(that is, a digit, a decimal point or a '-' sign)
        while (*input && !isdigit(*input) && *input != '-' && *input != '.')
            input++;
        if (!*input)
            break;
        /* Use strtod to read a floating-point value from the current position of input,
           and then store the location of the first character after the number it read
           back into the input pointer (so we can move on to the next value) */
        val = strtod(input,&input);
        out[i] = val;
    }
    return i;
} /* readNFloats */

/* testPrompt - Prompt for some input, and if no input is provided, return NULL. Otherwise, return a
   pointer to the first non-whitespace input character. If prompt is NULL, is is assumed
   that the caller will handle all prompts/feedback */
char* testPrompt(const char* prompt, char *outBuf, int bufLength){
    if (prompt){
        printf("%s",prompt);
        fflush(stdout);
    }
    if (fgets(outBuf,bufLength,stdin)){
        outBuf = firstNonWhitespaceCharacter(outBuf);
        if (*outBuf)
            return outBuf;
    }
    if (prompt)
        printf("\t No data provided - Skipping test.\n\n");
    return NULL;
} /* testPrompt */


/* startTest - Print a banner denoting the start of a test */
void startTest(char *testName){
    printf(" ****** Testing %s ******\n",testName);
}


/* testRoman - Test the roman_to_int function (Task 1)*/
void testRoman(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    startTest("roman_to_int");
    if(!(inputString = testPrompt("Enter a roman numeral: ",inputBuffer,sizeof(inputBuffer))))
        return;
    removeTrailingSpaces(inputString);
    printf("Integer representation of roman numeral \"%s\" is: %d\n\n",inputString,roman_to_int(inputString));
    fflush(stdout);
} /* testRoman */

/* testInvertCase - Test the invert_case function (Task 2)*/
void testInvertCase(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    startTest("invert_case");
    if(!(inputString = testPrompt("Enter a string for invert_case: ",inputBuffer,sizeof(inputBuffer))))
        return;
    removeTrailingSpaces(inputString);
    printf("Original string : \"%s\"\n",inputString);
    invert_case(inputString);
    printf("After invert_case: \"%s\"\n\n",inputString);
    fflush(stdout);
} /* testInvertCase*/

/* testMaxFibonacci - Test the max_fibonacci function (Task 3)*/
void testMaxFibonacci(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    startTest("max_fibonacci");
    if(!(inputString = testPrompt("Enter an upper limit: ",inputBuffer,sizeof(inputBuffer))))
        return;
    int max_value;
    if (readNInts(inputString,&max_value,1) != 1){
        printf("\t No value provided - skipping test.\n\n");
        return;
    }
    fflush(stdout);
    printf("Largest Fibonacci number less than or equal to %d: %d\n\n",max_value, max_fibonacci(max_value));
} /* testMaxFibonacci */

/* testLinearSearch - Test the linear_search function (Task 4)*/
void testLinearSearch(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    int n;
    int val;
    int numRead;
    int result;
    startTest("linear_search");
    if(!(inputString = testPrompt("Choose an array size for linear_search: ",inputBuffer,sizeof(inputBuffer))))
        return;
    if (readNInts(inputString,&n,1) != 1){
        printf("\t No size provided - skipping test.\n\n");
        return;
    }
    //Now create an array big enough to store n ints
    //C99 allows this kind of declaration (which is referred to as a 'variable length array')
    int A[n];
    printf("Enter %d values for linear_search: ",n);
    if(!(inputString = testPrompt("",inputBuffer,sizeof(inputBuffer))))
        return;
    if ((numRead = readNInts(inputString,A,n)) != n){
        printf("\t Only %d values were entered - skipping test.\n\n",numRead);
        return;
    }
    if(!(inputString = testPrompt("Enter a value to search for: ",inputBuffer,sizeof(inputBuffer))))
        return;
    if (readNInts(inputString,&val,1) != 1){
        printf("\t No value provided - skipping test.\n\n");
        return;
    }
    result = linear_search(A,n,val);
    if (result == NOT_FOUND)
        printf("linear_search returns NOT_FOUND when searching for %d.\n\n",val);
    else
        printf("linear_search returns %d when searching for %d.\n\n",result,val);
    fflush(stdout);
} /* testLinearSearch*/

/* testPascal - Test the pascals_triangle function (Task 5)*/
void testPascal(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    int n;
    int i,j;
    int A[PASCAL_MAX][PASCAL_MAX];
    startTest("pascals_triangle");
    if(!(inputString = testPrompt("Enter the number of rows of Pascal's triangle to generate: ",inputBuffer,sizeof(inputBuffer))))
        return;
    if (readNInts(inputString,&n,1) != 1){
        printf("\t No value provided - skipping test.\n\n");
        return;
    }
    if (n >= PASCAL_MAX){
        printf("\t Number of rows is too large - skipping test.\n\n");
        return;
    }
    pascals_triangle(A,n);
    printf("The first %d rows of Pascal's triangle are:\n",n);
    for(i = 0; i < n; i++){
        for (j = 0; j <= i; j++)
            printf("%2d ",A[i][j]);
        printf("\n");
    }
    printf("\n");
    fflush(stdout);
} /* testPascal*/

/* testShiftColumnsRight - Test the testShiftColumnsRight function (Task 6)*/
void testShiftColumnsRight(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    int rows_cols[2];
    int A[MATRIX_MAX][MATRIX_MAX];
    int i,j;
    startTest("shift_columns_right");
    if(!(inputString = testPrompt("Enter the number of rows and columns: ",inputBuffer,sizeof(inputBuffer))))
        return;
    if (readNInts(inputString,rows_cols,2) != 2){
        printf("\t No value provided - skipping test.\n\n");
        return;
    }
    int rows = rows_cols[0];
    int cols = rows_cols[1];
    if (rows >= MATRIX_MAX || rows < 1 || cols >= MATRIX_MAX || cols < 1){
        printf("\t Invalid rows (%d) or columns (%d) - skipping test.\n\n",rows,cols);
        return;
    }

    printf("Enter the contents of the matrix (one row per line):\n");
    fflush(stdout);
    for(i = 0; i < rows; i++){
        if(!(inputString = testPrompt(NULL,inputBuffer,sizeof(inputBuffer))))
            return;
        if (readNInts(inputString,&A[i][0],cols) != cols){
            printf("\t Too few values provided - skipping test.\n\n");
            return;
        }
    }
    shift_columns_right(A, rows,cols);
    printf("The shifted matrix is:\n");
    for(i = 0; i < rows; i++){
        for (j = 0; j < cols; j++)
            printf("%2d ",A[i][j]);
        printf("\n");
    }
    printf("\n");
    fflush(stdout);
} /* testShiftColumnsRight */

/* testStringLength - Test the string_length function (Task 7)*/
void testStringLength(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    startTest("string_length");
    if(!(inputString = testPrompt("Enter a string: ",inputBuffer,sizeof(inputBuffer))))
        return;
    removeTrailingSpaces(inputString);
    printf("Length of string \"%s\" is: %d\n\n",inputString,string_length(inputString));
    fflush(stdout);
} /* testStringLength */

/* testCopySuffix - Test the copy_suffix function (Task 8)*/
void testCopySuffix(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    char string[MAX_LINE], suffix[MAX_LINE];
    int start_position;
    startTest("copy_suffix");
    if(!(inputString = testPrompt("Enter a string: ",inputBuffer,sizeof(inputBuffer))))
        return;
    removeTrailingSpaces(inputString);
    strcpy(string,inputString);
    int len = strlen(string);
    printf("Enter a value between 0 and %d: ",len-1);
    fflush(stdout);
    if(!(inputString = testPrompt(NULL,inputBuffer,sizeof(inputBuffer))))
        return;
    if (readNInts(inputString,&start_position,1) != 1){
        printf("\t No value provided - skipping test.\n\n");
        return;
    }
    if (start_position < 0 || start_position >= len){
        printf("\t Invalid value provided - skipping test.\n\n");
        return;
    }
    printf("Input string is \"%s\"\n",string);
    suffix[0] = '\0';
    copy_suffix(string,suffix,start_position);
    suffix[MAX_LINE-1] = '\0';
    printf("Suffix starting at index %d is: \"%s\"\n\n",start_position,suffix);
    fflush(stdout);
} /* testCopySuffix */

/* testMirrorString - Test the mirror_string function (Task 9)*/
void testMirrorString(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    char string[MAX_LINE*2];
    startTest("mirror_string");
    if(!(inputString = testPrompt("Enter a string: ",inputBuffer,sizeof(inputBuffer))))
        return;
    removeTrailingSpaces(inputString);
    strcpy(string,inputString);
    printf("Original string: \"%s\"\n",string);
    mirror_string(string);
    string[2*MAX_LINE-1] = '\0';
    printf("After mirroring: \"%s\"\n\n",string);
    fflush(stdout);
} /* testMirrorString */

/* testDecrypt - Test the decrypt function (Task 10)*/
void testDecrypt(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    char decodedString[MAX_LINE];
    startTest("decrypt");
    if(!(inputString = testPrompt("Enter a coded message (lowercase letters only): ",inputBuffer,sizeof(inputBuffer))))
        return;
    removeTrailingSpaces(inputString);
    char *s = inputString;
    while(*s){
        if (!islower(*s)){
            printf("\t String does not contain only lowercase letters - skipping test.\n\n");
            return;
        }
        s++;
    }
    printf(" Coded message: \"%s\"\n",inputString);
    decodedString[0] = '\0';
    decrypt(inputString,decodedString);
    decodedString[MAX_LINE-1] = '\0';
    printf("After decoding: \"%s\"\n\n",decodedString);
    fflush(stdout);
} /* testDecrypt */

/* testIsPalindrome - Test the is_palindrome function (Task 11) */
void testIsPalindrome() {
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    startTest("is_palindrome");
    if(!(inputString = testPrompt("Enter a message: ",inputBuffer,sizeof(inputBuffer))))
        return;
    removeTrailingSpaces(inputString);

    printf("Original string: \"%s\"\n",inputString);
    bool result = is_palindrome(inputString);
    printf("is_palindrome returns %s\n\n", (result?"true":"false"));
    fflush(stdout);
} /* testIsPalindrome */

/* testRemoveVowels - Test the remove_vowels function (Task 12) */
void testRemoveVowels(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    char outputString[MAX_LINE];
    startTest("remove_vowels");
    if(!(inputString = testPrompt("Enter a string: ",inputBuffer,sizeof(inputBuffer))))
        return;
    removeTrailingSpaces(inputString);

    printf("Original String: \"%s\"\n",inputString);
    outputString[0] = '\0';
    remove_vowels(inputString,outputString);
    outputString[MAX_LINE-1] = '\0';
    printf("After processing: \"%s\"\n\n",outputString);
    fflush(stdout);
} /* testRemoveVowels */

/* testDBP - Test the dist_between_points function (Task 13)*/
void testDBP(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    Point p1,p2;
    float xy[2];
    startTest("dist_between_points");
    if(!(inputString = testPrompt("Enter x & y for the first point: ",inputBuffer,sizeof(inputBuffer))))
        return;
    if (readNFloats(inputString,xy,2) != 2){
        printf("\t Wrong number of values provided - skipping test.\n\n");
        return;
    }
    p1.x = xy[0];
    p1.y = xy[1];
    if(!(inputString = testPrompt("Enter x & y for the second point: ",inputBuffer,sizeof(inputBuffer))))
        return;
    if (readNFloats(inputString,xy,2) != 2){
        printf("\t Wrong number of values provided - skipping test.\n\n");
        return;
    }
    p2.x = xy[0];
    p2.y = xy[1];
    printf("The distance between (%.2f,%.2f) and (%.2f,%.2f) is: %f\n\n",p1.x,p1.y,p2.x,p2.y,dist_between_points(&p1,&p2));
    fflush(stdout);
} /* testDBP */

/* testCNP - Test the count_nearby_points function (Task 14)*/
void testCNP(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    PointListNode *list = NULL;
    float xy[2];
    Point centre;
    float radius;
    int count;
    startTest("count_nearby_points");
    if(!(inputString = testPrompt("Enter x & y for the centre point: ",inputBuffer,sizeof(inputBuffer))))
        return;
    if (readNFloats(inputString,xy,2) != 2){
        printf("\t Wrong number of values provided - skipping test.\n\n");
        return;
    }
    centre.x = xy[0];
    centre.y = xy[1];
    if(!(inputString = testPrompt("Enter a radius: ",inputBuffer,sizeof(inputBuffer))))
        return;
    if (readNFloats(inputString,&radius,1) != 1){
        printf("\t Wrong number of values provided - skipping test.\n\n");
        return;
    }

    //Now allow the user to enter as many points as they want
    printf("Creating point list - Enter as many points as you want, and leave a line blank when you are done.\n");
    count = 0;
    while (1){
        printf("Enter x & y for point %d: ",count+1);
        fflush(stdout);
        if(!(inputString = testPrompt(NULL,inputBuffer,sizeof(inputBuffer))))
            break;
        if (readNFloats(inputString,xy,2) != 2){
            printf("\t Wrong number of values provided - ending list.\n");
            break;
        }
        list = addPointToList(list,allocateNewPoint(xy[0],xy[1]));
        count++;
    }
    list = reversePointList(list);
    printf("The list of points is: ");
    printPointList(list);
    printf("\n");
    printf("The number of points within radius %.2f from (%.2f,%.2f) is: %d\n\n",radius,centre.x,centre.y,count_nearby_points(list,&centre,radius));
    freePointList(list);
    fflush(stdout);
} /* testCNP */



/* testAddPointAtEnd - Test the add_point_at_end function (Task 15)*/
void testAddPointAtEnd(){
    char inputBuffer[MAX_LINE];
    inputBuffer[MAX_LINE-1] = '\0';
    char *inputString;
    PointListNode *list = NULL;
    Point* newPoint = NULL;
    float xy[2];
    int count;
    startTest("add_point_at_end");

    //Now allow the user to enter as many points as they want
    printf("Creating point list - Enter as many points as you want, and leave a line blank when you are done.\n");
    count = 0;
    while (1){
        printf("Enter x & y for point %d: ",count+1);
        fflush(stdout);
        if(!(inputString = testPrompt(NULL,inputBuffer,sizeof(inputBuffer))))
            break;
        if (readNFloats(inputString,xy,2) != 2){
            printf("\t Wrong number of values provided - ending list.\n");
            break;
        }
        list = addPointToList(list,allocateNewPoint(xy[0],xy[1]));
        count++;
    }
    if (count == 0){
        printf("\t No data provided - Skipping test.\n\n");
        return;
    }
    list = reversePointList(list);
    printf("The list of points is: ");
    printPointList(list);
    printf("\n");
    printf("Enter x & y for a point to add at the end of the list: ");
    fflush(stdout);
    if(!(inputString = testPrompt("",inputBuffer,sizeof(inputBuffer))))
        return;
    if (readNFloats(inputString,xy,2) != 2){
        printf("\t Wrong number of values provided - skipping test.\n\n");
        return;
    }
    newPoint = allocateNewPoint(xy[0],xy[1]);
    printf("Adding the point (%.2f,%.2f) to the end of the list with add_point_at_end\n",newPoint->x,newPoint->y);
    add_point_at_end(list,newPoint);
    printf("The modified list of points is: ");
    printPointList(list);
    printf("\n");
    freePointList(list);
    fflush(stdout);
} /* testAddPointAtEnd */
