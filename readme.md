

## EdDSA数字签名算法

### 概述

新加入基于Edwards-Curve数字签名算法(EdDSA-Edwards-Curve Digital Signature Algorithm)的加密签名，即**爱德华兹曲线数字签名算法**。

在许多其它加密库（如 OpenSSL 和 BoringSSL）中得到支持。

与 JDK 中的现有签名方案相比，EdDSA 具有更高的安全性和性能，因此备受关注。它已经在OpenSSL和BoringSSL等加密库中得到支持，在区块链领域用的比较多。

EdDSA是一种现代的椭圆曲线方案，具有JDK中现有签名方案的优点。





### 使用

```java
package mao;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

/**
 * Project name(项目名称)：JDK15_EdDSA
 * Package(包名): mao
 * Class(类名): Test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/12
 * Time(创建时间)： 17:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test1
{
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException
    {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("Ed25519");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        Signature signature = Signature.getInstance("Ed25519");
        signature.initSign(keyPair.getPrivate());
        signature.update("hello".getBytes(StandardCharsets.UTF_8));
        byte[] s = signature.sign();
        String encodedString = Base64.getEncoder().encodeToString(s);
        System.out.println(encodedString);

        signature.update("hello".getBytes(StandardCharsets.UTF_8));
        s = signature.sign();
        encodedString = Base64.getEncoder().encodeToString(s);
        System.out.println(encodedString);

        signature.update("world".getBytes(StandardCharsets.UTF_8));
        s = signature.sign();
        encodedString = Base64.getEncoder().encodeToString(s);
        System.out.println(encodedString);

        signature.update("hello world".getBytes(StandardCharsets.UTF_8));
        s = signature.sign();
        encodedString = Base64.getEncoder().encodeToString(s);
        System.out.println(encodedString);

        signature.initVerify(keyPair.getPublic());
        System.out.println(signature.verify("hello".getBytes(StandardCharsets.UTF_8)));
        System.out.println(signature.verify("world".getBytes(StandardCharsets.UTF_8)));
        System.out.println(signature.verify("hello world".getBytes(StandardCharsets.UTF_8)));
    }
}
```



```sh
n+dmyuGKd2J+Pl3wcALZSam9g5NosrTGtmAIOHj1sB9LGzk+Ir4NyMl0VjywqmqIguJw+6hmoklIbFFZzTMVCA==
n+dmyuGKd2J+Pl3wcALZSam9g5NosrTGtmAIOHj1sB9LGzk+Ir4NyMl0VjywqmqIguJw+6hmoklIbFFZzTMVCA==
Ejlzxtmi1sbqHKJgpis7gfNQDXil4B/W9N4Z8mHAQu7XNIMAKrROZLzXewggOQ1lc0fMXAGG+zmJy/ZiM1ODAw==
lMuVMqv3HdXiX9Kr5GxbsDglLFzEqd+rnZSFRh2h/rXnWfYfV7oCQhZ5zUqYn+B7RDI7WX84jt09/edOkBMQAA==
false
false
false
```



