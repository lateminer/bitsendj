package com.hashengineering.crypto;

import org.bitcoinj.core.Sha256Hash;

import fr.cryptohash.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by Hash Engineering on 4/24/14 for the X11 algorithm
 * updated by madzebra on 10/11/2016 for the Xevan algorithm
 */
public class Xevan {

    private static final Logger log = LoggerFactory.getLogger(Xevan.class);

    public static byte[] XevanDigest(byte[] input, int offset, int length)
    {
        byte [] buf = new byte[length];
        for(int i = 0; i < length; ++i)
        {
            buf[i] = input[offset + i];
        }
        return XevanDigest(buf);
    }

    public static byte[] XevanDigest(byte[] input) {
        long start = System.currentTimeMillis();
        try {
            return XEVAN(input);
        } catch (Exception e) {
            return null;
        }
        finally {
            long time = System.currentTimeMillis()-start;
            log.info("XEVAN Hash time: {} ms per block", time);
        }
    }

    static byte [] XEVAN(byte header[])
    {
        //Initialize
        Sha512Hash[] hash = new Sha512Hash[34];

        BLAKE512 blake = new BLAKE512();
        BMW512 bmw = new BMW512();
        Groestl512 groestl = new Groestl512();
        Skein512 skein = new Skein512();
        JH512 jh = new JH512();
        Keccak512 keccak = new Keccak512();
        Luffa512 luffa = new Luffa512();
        CubeHash512 cubehash = new CubeHash512();
        SHAvite512 shavite = new SHAvite512();
        SIMD512 simd = new SIMD512();
        ECHO512 echo = new ECHO512();
        Hamsi512 hamsi = new Hamsi512();
        HAVAL256_5 haval = new HAVAL256_5();
        SHA512 sha512 = new SHA512();
        Whirlpool whirlpool = new Whirlpool();
        Shabal512 shabal = new Shabal512();
        Fugue512 figue = new Fugue512();

        // Part 1
        hash[0] = new Sha512Hash(blake.digest(header));
        hash[1] = new Sha512Hash(bmw.digest(hash[0].getBytes()));
        hash[2] = new Sha512Hash(groestl.digest(hash[1].getBytes()));
        hash[3] = new Sha512Hash(skein.digest(hash[2].getBytes()));
        hash[4] = new Sha512Hash(jh.digest(hash[3].getBytes()));
        hash[5] = new Sha512Hash(keccak.digest(hash[4].getBytes()));
        hash[6] = new Sha512Hash(luffa.digest(hash[5].getBytes()));
        hash[7] = new Sha512Hash(cubehash.digest(hash[6].getBytes()));
        hash[8] = new Sha512Hash(shavite.digest(hash[7].getBytes()));
        hash[9] = new Sha512Hash(simd.digest(hash[8].getBytes()));
        hash[10] = new Sha512Hash(echo.digest(hash[9].getBytes()));
        hash[11] = new Sha512Hash(hamsi.digest(hash[10].getBytes()));
        hash[12] = new Sha512Hash(figue.digest(hash[11].getBytes()));
        hash[13] = new Sha512Hash(shabal.digest(hash[12].getBytes()));
        hash[14] = new Sha512Hash(whirlpool.digest(hash[13].getBytes()));
        hash[15] = new Sha512Hash(sha512.digest(hash[14].getBytes()));
        hash[16] = new Sha512Hash(expand(haval.digest(hash[15].getBytes())));

        //  Part 2
        hash[17] = new Sha512Hash(blake.digest(hash[16].getBytes()));
        hash[18] = new Sha512Hash(bmw.digest(hash[17].getBytes()));
        hash[19] = new Sha512Hash(groestl.digest(hash[18].getBytes()));
        hash[20] = new Sha512Hash(skein.digest(hash[19].getBytes()));
        hash[21] = new Sha512Hash(jh.digest(hash[20].getBytes()));
        hash[22] = new Sha512Hash(keccak.digest(hash[21].getBytes()));
        hash[23] = new Sha512Hash(luffa.digest(hash[22].getBytes()));
        hash[24] = new Sha512Hash(cubehash.digest(hash[23].getBytes()));
        hash[25] = new Sha512Hash(shavite.digest(hash[24].getBytes()));
        hash[26] = new Sha512Hash(simd.digest(hash[25].getBytes()));
        hash[27] = new Sha512Hash(echo.digest(hash[26].getBytes()));
        hash[28] = new Sha512Hash(hamsi.digest(hash[27].getBytes()));
        hash[29] = new Sha512Hash(figue.digest(hash[28].getBytes()));
        hash[30] = new Sha512Hash(shabal.digest(hash[29].getBytes()));
        hash[31] = new Sha512Hash(whirlpool.digest(hash[30].getBytes()));
        hash[32] = new Sha512Hash(sha512.digest(hash[31].getBytes()));
        hash[33] = new Sha512Hash(expand(haval.digest(hash[32].getBytes())));

        return hash[33].trim256().getBytes();
    }

    /**
     * Expands array 32 bytes long to array 64 bytes long.
     */
    private static byte [] expand(byte [] input) {
        checkArgument(input.length == 32);

        byte [] result = new byte[64];
        byte zero = 0;
        Arrays.fill(result, zero);

        for (int i = 0 ; i < 32; i++)
            result[i] = input[i];

        return result;
    }
}
