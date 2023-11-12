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
