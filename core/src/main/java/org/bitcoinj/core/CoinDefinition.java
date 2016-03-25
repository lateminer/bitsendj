package org.bitcoinj.core;

import java.math.BigInteger;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Hash Engineering Solutions
 * Date: 5/3/14
 * To change this template use File | Settings | File Templates.
 */
public class CoinDefinition {

    public static final String coinName = "BitSend";
    public static final String coinTicker = "BSD";
    public static final String coinURIScheme = "bitsend";
    public static final String cryptsyMarketId = "309";
    public static final String cryptsyMarketCurrency = "BTC";
    public static final String PATTERN_PRIVATE_KEY_START_UNCOMPRESSED = "[7]";
    public static final String PATTERN_PRIVATE_KEY_START_COMPRESSED = "[i]";

    public enum CoinPrecision {
        Coins,
        Millicoins,
    }
    public static final CoinPrecision coinPrecision = CoinPrecision.Coins;
	
    public static final String UNSPENT_API_URL = "https://chainz.cryptoid.info/uno/api.dws?q=unspent";
    public enum UnspentAPIType {
        BitEasy,
        Blockr,
        Abe,
        Cryptoid,
    };
    public static final UnspentAPIType UnspentAPI = UnspentAPIType.Cryptoid;
	
    public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://www.multifaucet.tk/index.php?blockexplorer=BSD";
    public static final String BLOCKEXPLORER_ADDRESS_PATH = "&address=";
    public static final String BLOCKEXPLORER_TRANSACTION_PATH = "&txid=";
    public static final String BLOCKEXPLORER_BLOCK_PATH = "&block=";
    public static final String BLOCKEXPLORER_BASE_URL_TEST = "";

    public static final String DONATION_ADDRESS = "i6yaT9wUGDqCk7abqGyQi77p6n7ZFdkmiX";
    

    enum CoinHash {
        SHA256,
        scrypt,
        x11
    };
    public static final CoinHash coinPOWHash = CoinHash.x11;

    public static boolean checkpointFileSupport = true;

    public static final int TARGET_TIMESPAN = (int)(6 * 24 * 60 * 60);
    public static final int TARGET_SPACING = (int)(5 * 60);
    public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;

    public static final int getInterval(int height, boolean testNet) {
            return INTERVAL;
    }
    public static final int getIntervalCheckpoints() {
            return INTERVAL;

    }
    public static final int getTargetTimespan(int height, boolean testNet) {
            return TARGET_TIMESPAN;
    }

    public static int spendableCoinbaseDepth = 25;
    public static final long MAX_COINS = 525000000;

    public static final long DEFAULT_MIN_TX_FEE = 5000;
    public static final long DUST_LIMIT = 500;

    public static final long INSTANTX_FEE = 1000000;

    public static final int PROTOCOL_VERSION = 70077;
    public static final int MIN_PROTOCOL_VERSION = 70077;

    public static final int BLOCK_CURRENTVERSION = 3;
    public static final int MAX_BLOCK_SIZE = 4000000;

    public static final boolean supportsBloomFiltering = true;

    public static final int Port    = 8886;
    public static final int TestPort = 8885;

    //
    //  Production
    //
    public static final int AddressHeader = 102;
    public static final int p2shHeader = 5;
    public static final boolean allowBitcoinPrivateKey = false;
    public static final int dumpedPrivateKeyHeader = 128;
    // public static final long oldPacketMagic = 0xfbc0b6db;
    public static final long PacketMagic = 0xa3d5c2f9;
		
    static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);
    static public long genesisBlockTime = 1402097469L;
    static public long genesisBlockNonce = (34784351);
    static public String genesisHash = "0000012e1b8843ac9ce8c18603658eaf8895f99d3f5e7e1b7b1686f35e3c087a";
    static public String genesisMerkleRoot = "c0c4f68994b78c31b6c7d7a8a895b5a085857adfbb73699bcfe5a247a357df57";
    static public int genesisBlockValue = 100;

    static public String genesisTxInBytes = "04ffff001d01043b6c696d65636f696e58206f667265636520616d706c69612067616d6120646520736572766963696f732079206d656a6f7261732070617261207469";
    static public String genesisTxOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";
    // static public String genesisTxOutBytes = "41040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9ac";
    // static public String genesisTxOutBytes = "040184710fa689ad5023690c80f3a49c8f13f8d45b8c857fbcbc8bc4a8e4d3eb4b10f4d4604fa08dce601aaf0f470216fe1b51850b4acf21b179c45070ac7b03a9";

    static public String[] dnsSeeds = new String[] {
            "108.61.179.50",
            "37.120.190.76",
            "85.214.68.75",
            "68.197.13.94",
            "46.188.4.74",
            "107.170.2.241",
            "45.58.51.22",
            "104.207.131.249",
            "68.197.13.94",
            "109.30.168.16",
            "31.41.247.133",
            "5.230.218.51",
            "151.80.201.100",
            "195.54.3.213",
            "134.3.162.242",
    };

    public static int minBroadcastConnections = 0;

    public static final Coin GetBlockReward(int height)
    {
        int COIN = 1;
        Coin nSubsidy = Coin.valueOf(50, 0);
        if (height == 1)
            nSubsidy = Coin.valueOf(1306400, 0);
        return nSubsidy;
    }

    public static int subsidyDecreaseBlockCount = 210000;

    public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);

    public static final String SATOSHI_KEY = "";

    /** The string returned by getId() for the main, production network where people trade things. */
    public static final String ID_MAINNET = "org.bitsend.production";
    /** The string returned by getId() for the testnet. */
    public static final String ID_TESTNET = "org.bitsend.test";
    /** Unit test network. */
    public static final String ID_UNITTESTNET = "com.google.bitsend.unittest";

    public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
    {
        checkpoints.put(      0, Sha256Hash.wrap("0000012e1b8843ac9ce8c18603658eaf8895f99d3f5e7e1b7b1686f35e3c087a"));
        
    }

    //
    // TestNet - NOT TESTED
    //
    public static final boolean supportsTestNet = false;
    public static final int testnetAddressHeader = 111;
    public static final int testnetp2shHeader = 196;
    public static final long testnetPacketMagic = 0x4c1a2caf;
    public static final String testnetGenesisHash = "000008030a1e9a647ecc6119e0782166552e49dadfa8353afa26f3a6c2179845";
    static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);
    static public long testnetGenesisBlockTime = 1402095180L;
    static public long testnetGenesisBlockNonce = (386986707);

    static public String[] testnetDnsSeeds = new String[] {
            "85.214.68.75",
    };

    public static final String TESTNET_SATOSHI_KEY = "04517d8a699cb43d3938d7b24faaff7cda448ca4ea267723ba614784de661949bf632d6304316b244646dea079735b9a6fc4af804efb4752075b9fe2245e14e412";

    public static final String UNITTEST_ADDRESS = "";
    public static final String UNITTEST_ADDRESS_PRIVATE_KEY = "";

}
