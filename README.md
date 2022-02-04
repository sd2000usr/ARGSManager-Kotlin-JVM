# ARGSManager-Kotlin-JVM
add function to argRequest

## example:
```kotlin


fun main(args: Array<String>) //args input: -s file0.txt file1.txt
{

    ARGSManager.onArg("-s")
    {
        println("show something")
    }

    ARGSManager.manageArgs(args)
    {
        it.forEachIndexed { index, s -> println("arg[$index]: $s") }
    }

}

/* 
output:

show something
arg[0]: file0.txt
arg[1]: file1.txt

*/
    
```
