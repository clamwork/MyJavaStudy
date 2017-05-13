package cn.com.arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * 双数组Trie树(DoubleArrayTrie)是一种空间复杂度低的Trie树，应用于字符区间大的语言（如中文、日文等）分词领域。
 * 测试demo
 * @author Chengw
 * @since 2017/5/13 13:23.
 */
public class DoubleArrayTrieDemo {

    static Logger logger =Logger.getLogger(DoubleArrayTrieDemo.class.getName());


    public static void main(String[] args) throws IOException{
        FileReader fr = new FileReader("./data/small.dic");
        BufferedReader br = new BufferedReader(fr);

        String line;
        List<String> words = new ArrayList<String>();
        Set<Character> charset = new HashSet<Character>();
        while((line = br.readLine()) != null){
            words.add(line);
            for(char c : line.toCharArray()){
                charset.add(c);
            }

        }
        br.close();

        logger.info("字典条数:" +words.size());

        {
            String infoCharsetValue = "";
            String infoCharsetCode = "";
            for (Character c:charset)
            {
                infoCharsetValue += c.charValue() +"    ";
                infoCharsetCode += (int)c.charValue() + " ";
            }
            infoCharsetValue += "\n";
            infoCharsetCode += "\n";
            logger.info(infoCharsetValue);
            logger.info(infoCharsetCode);
        }

        DoubleArrayTrie dat = new DoubleArrayTrie();
        logger.info("是否错误:" +dat.build(words));
        System.out.println(dat);
        List<Integer> integerList = dat.commonPrefixSearch("一举成名天下知");
        for (int index : integerList)
        {
            logger.info(words.get(index));
        }

    }

}
