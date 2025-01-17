# iebis_swdev_debugging
Source code to test debugging

## Instructions
First, **Fork** this project.

There are three exercises splitted in three branches of this repository. You must switch branches to checkout the code of each exercise.
Then, find the bugs that appear in each branch.
Fix the bugs if you can and answer to the questions proposed below.
Commit the code before checking out a different branch to avoid loosing the fixes that you have made to the code.

Once that you are done fixing bugs, **to score you must**:
1. Switch to the master branch.
2. Type below in this README.md file the answer to each question and paste some code that you have used to solve them.
3. Commit the changes
4. Push to your GitHub repository
5. **Finally place a Pull Request so I can see your proposed answers**


## Exercises
### Exercise 1
In this code there is a class called WordAnalyzer that contains several methods that analyzes some characteristics of the word passed as argument when the object WordAnalyzer is created.

For some reason, the methods are not working properly, sometimes they return the correct value and others don't. You need to answer the next questions.

#### Why the method _firstMultipleCharacter_ is returning "c" for the word _comprehensive_, when the correct answer should be "e"?
The method _firstMultipleCharacter_ returns the value of the first char of the input, this is because i is equal to pos, so the first letter will always be the outcome of this function.

We add 1 to pos in the loop, so it it will no longer return i


This is the solution:

>for (int i = pos + 1; i < word.length(); i++)
#### Why the method _firstRepeatedCharacter_ is throwing an exception?
The exception _StringIndexOutOfBoundsException_ happens because a char or item outside the input (word) is being called, to fix this, we need to reduce 1 to the length 

This is the solution:
>for (int i = 0; i < word.length()-1; i++)

#### Why the method _countGroupsRepeatedCharacters_ returns 3 in one case when it should be 4?
The loop starts in int i=1, so it does not check repeated characters in the first two characters of the word. We need to change the condition to i=0 so it checks the first chars
>for (int i = 0; i < word.length() - 1; i++)

When we run it, an exception is returned, we need to add a piece of code to tell the program what to do if the first 2 chars are not equal. So we add:
> if (i != 0) {
           if (word.charAt(i - 1) != word.charAt(i)) // it't the start
            c++;

**Strategy**: Place breakpoints before the methods are executed, step into them and see what happens.


### Exercise 2
In this code we are placing mines in a board game where we have several spaces that can be mined. 
The boards can contain _Element_ objects, and since _Space_ and _Mine_ inherits from _Element_, the boards can contain this kind as well.

We have two boards of different size and place a different number of mines on each one. But in the second case it takes longer to place all the mines.

#### Why placing less bombs takes longer in the second case?
The first case is the REDBOARD, which has 500000 more spaces than the BLUEBORARD. Whe we run to plant the bombs, in the REDBOARD we have more spaces to leave free, therefore the random function runs faster. In the other case, we are only leaving one space free, which makes it harder for the drandom function to place all the bombs.
#### Knowing that usually there are going to be more bombs than spaces in the final boards, how would you change the method _minningTheBoard_ to be more efficient?
Instead of placing the bombs I would fill all the board with bombs and create a function to take out bombs and create empty spaces, this would make it faster.

**Strategy**: Understand well what the code does. Use conditionals breakpoints.


### Exercise 3
In this case this code looks really simple. When the "d" reaches the value 1.0, the program should end, but it never does.

#### Why does not appear a message indicating that "d is 1"?
Doubles work in Java in a different way. Using breakpoints errors accumulate in this program, it keeps adding decimals, therefore d is and will never be 1.0, so it can't print "d is 1".

#### How will you fix it?
Java has a Math class called [BigDecimal](https://stackoverflow.com/questions/3413448/double-vs-bigdecimal),it is an exact way of representing numbers. To use it, first we need to import it. The accumulated error previously mentioned can be mitigated by using BigDecimal.**setScale**, which allows rounding (floats and doubles don't). 

    public static void main(String [] args) {
        BigDecimal a = new BigDecimal(0.0);
        BigDecimal b = new BigDecimal(1.0);
        BigDecimal c = new BigDecimal(0.1);

        while (a.compareTo(b) != 0) {
            BigDecimal sum = a.add(c);
            a = sum.setScale(2, RoundingMode.FLOOR);

        }

        System.out.println("a is 1");
    }}
