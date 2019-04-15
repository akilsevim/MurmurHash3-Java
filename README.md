# MurmurHash3_32_Long
**A Java and JavaScript implementation of [MurmurHash3](https://github.com/aappleby/smhasher)'s x86_32 hashing algorithm for Long type inputs.**

This program prepared to have same hashing results from both Java and JavaScript for Long inputs.

## Usage
To use Java version, just add the MurmurHash3_32_Long class into your sources folder and use it as described below.

```java
int seed = 0;
long key = 123456;
int hash = MurmurHash3_32_Long.hash(key, seed);
```

For JavaScript, since the long type is not supported natively, we used a library called [BigInteger.js](https://github.com/peterolson/BigInteger.js). 
There were other libraries too, but BigInteger.js works as a polyfill which means that if the environment supports the native BigInt, 
the library acts as a thin wrapper over the native implementation.

So, to use JavaScript version, first the BigInteger.js, and than the MurmurHash3_32_Long.js, which you can find in resources folder, need to be linked. After that, you can call the MurmurHash3_32_Long function as described below.

```JavaScript
var seed = 0;
var key = bigInt(123456);
var hash = MurmurHash3_32_Long(key, seed);
```

## Test

In order to test the outputs of hashing functions, the Jetty server is embedded into the program.
When you run the program, the server will start using the port 8890. Then, you will be able to access to the http://localhost:8890.
There you will find a HTML page, which can test the outputs of both functions for multiple key and seed values. It sends ajax requests to the Jetty server
and gets the results of the Java function, then compares it with the JavaScript function's output.