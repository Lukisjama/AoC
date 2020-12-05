import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	public static void main(String[] args) {
		int validPass = 0;
		int validData = 0;
		String[] puzzle;
		Set<String> validPasswordsSet = new HashSet<String>();
		
		String rawPuzzle = "hgt:159cm\n" + "pid:561068005 eyr:2025 iyr:2017 cid:139 ecl:blu hcl:#ceb3a1\n"
				+ "byr:1940\n" + "\n" + "iyr:2014\n" + "byr:1986 pid:960679613 eyr:2025 ecl:hzl\n" + "\n"
				+ "cid:211 ecl:blu hcl:#7d3b0c iyr:2011 pid:006632702\n" + "byr:1982 eyr:2023 hgt:68in\n" + "\n"
				+ "hcl:#341e13 hgt:192 iyr:2028\n" + "ecl:utc\n" + "eyr:2027 byr:1979 pid:653515689\n" + "\n"
				+ "eyr:2026 hgt:161cm ecl:#1850b8\n" + "pid:298779494 hcl:b2114e iyr:1953\n" + "\n" + "hgt:155cm\n"
				+ "hcl:#a97842 iyr:2019\n" + "ecl:gry byr:1939\n" + "pid:935099157 eyr:2027\n" + "\n"
				+ "eyr:2024 ecl:grn\n" + "pid:102781360 byr:1962 iyr:2013 hcl:#602927\n" + "\n"
				+ "hcl:#602927 hgt:152cm\n" + "pid:659074205 ecl:brn iyr:2014 byr:1951\n" + "\n"
				+ "iyr:2025 hcl:8464b2 byr:2030 pid:976783295 hgt:155cm ecl:dne\n" + "\n"
				+ "hcl:#ceb3a1 byr:1984 pid:863872932\n" + "iyr:2016 hgt:190cm ecl:grn eyr:2026\n" + "\n"
				+ "eyr:2030 hcl:#efcc98\n" + "cid:166 pid:894418497 ecl:hzl\n" + "hgt:189cm iyr:2014 byr:1966\n" + "\n"
				+ "byr:1937 iyr:2017 eyr:2028\n" + "ecl:amb\n" + "hgt:165cm cid:84\n" + "pid:435289747\n" + "\n"
				+ "hgt:166cm hcl:#6b5442 byr:1953 eyr:2023 iyr:2010\n" + "pid:948173962 ecl:amb\n" + "\n"
				+ "byr:1962 cid:276 iyr:2010 hgt:183cm pid:097154397\n" + "hcl:#341e13 eyr:2024\n" + "\n" + "hgt:61cm\n"
				+ "byr:1942 ecl:xry hcl:#05e97d pid:42823283\n" + "eyr:2024\n" + "\n" + "hcl:#888785\n"
				+ "pid:960190685 byr:1967 iyr:2012 cid:99 eyr:2021\n" + "hgt:76in\n" + "\n"
				+ "eyr:2025 byr:1958 hcl:#18171d iyr:2012 pid:759427419\n" + "ecl:hzl\n" + "\n" + "ecl:#829d2e\n"
				+ "cid:60 iyr:2028\n" + "byr:1979 hcl:caff12 eyr:1931 pid:#fd7aab hgt:184cm\n" + "\n"
				+ "cid:251 byr:1981 pid:625590775\n" + "hcl:#a97842 eyr:2020\n" + "ecl:amb hgt:178cm\n" + "iyr:2016\n"
				+ "\n" + "pid:026891577 ecl:amb byr:2014\n" + "hcl:bc419f eyr:2026\n" + "iyr:1948\n"
				+ "hgt:123 cid:67\n" + "\n" + "ecl:hzl\n" + "hgt:152cm hcl:#efcc98\n" + "byr:1993\n" + "eyr:2025\n"
				+ "\n" + "ecl:grn iyr:1924 eyr:2039 pid:8441306576\n" + "hgt:163in\n" + "byr:2012\n" + "cid:193\n"
				+ "\n" + "ecl:#78f4fa\n" + "eyr:2020 hgt:165cm byr:1965 pid:987868257 iyr:2012\n" + "cid:331 hcl:z\n"
				+ "\n" + "ecl:brn cid:289 pid:868305933\n" + "byr:1936 hgt:174cm iyr:2016 hcl:#623a2f eyr:2021\n" + "\n"
				+ "hcl:#2a6308 eyr:2027 hgt:154cm ecl:grn\n" + "iyr:2012\n" + "byr:1940\n" + "pid:675209536\n" + "\n"
				+ "pid:186cm eyr:2022\n" + "hcl:#fffffd hgt:151cm iyr:2016 ecl:hzl byr:1954\n" + "\n"
				+ "ecl:grn hgt:177cm pid:725111435 byr:1927 eyr:2027 cid:154 iyr:2010 hcl:#623a2f\n" + "\n"
				+ "pid:801551597 cid:55 eyr:2028 hgt:193cm hcl:#a97842\n" + "ecl:hzl byr:1942 iyr:2015\n" + "\n"
				+ "cid:176 eyr:2030 iyr:2018 byr:1932 hgt:162cm pid:896180324 ecl:amb hcl:#6b5442\n" + "\n"
				+ "cid:239 ecl:grn iyr:1953 pid:9500162195\n" + "byr:1998\n" + "hgt:182cm hcl:#733820 eyr:1966\n" + "\n"
				+ "eyr:2030\n" + "pid:919325322 hcl:z iyr:2024 hgt:71cm ecl:#1e935c byr:2026\n" + "\n" + "iyr:2012\n"
				+ "ecl:gry eyr:2025 hcl:#602927 hgt:168cm byr:1925\n" + "pid:303312675\n" + "\n"
				+ "hgt:150in iyr:2014 ecl:gry eyr:2029\n" + "byr:2029\n" + "cid:228\n" + "\n"
				+ "ecl:#9524e0 byr:2026 hcl:z\n" + "iyr:2023\n" + "cid:325\n" + "eyr:1996\n"
				+ "pid:6172325031 hgt:191\n" + "\n" + "ecl:#689e88\n" + "eyr:1937\n" + "cid:75 byr:1963 iyr:2024\n"
				+ "pid:4980937 hgt:156cm\n" + "hcl:#fffffd\n" + "\n" + "pid:719820090 iyr:2020 hgt:165cm\n"
				+ "hcl:#ceb3a1 byr:1997 ecl:blu eyr:2027\n" + "\n" + "eyr:2025\n" + "pid:241723456\n" + "iyr:2011\n"
				+ "byr:1953 cid:230 hgt:185cm hcl:#efcc98 ecl:oth\n" + "\n" + "byr:1936 hcl:#623a2f\n"
				+ "iyr:2010 hgt:156cm\n" + "eyr:2022\n" + "pid:064253102 ecl:brn\n" + "\n"
				+ "cid:332 hcl:#a97842 eyr:2026 ecl:gry iyr:2019 pid:#4e4a46\n" + "hgt:150cm\n" + "byr:1987\n" + "\n"
				+ "ecl:grn hgt:67in\n" + "iyr:2012\n" + "byr:1953 pid:910793005 hcl:#341e13 eyr:2020\n" + "\n"
				+ "iyr:2024 eyr:2030 cid:204 hgt:166cm pid:218828260\n" + "hcl:701b48 ecl:gry byr:1930\n" + "\n"
				+ "hgt:162cm pid:024916763 eyr:2026 ecl:hzl\n" + "hcl:#efcc98 iyr:2019 byr:1921\n" + "\n" + "eyr:2025\n"
				+ "iyr:2017 ecl:hzl hcl:#fffffd hgt:167cm pid:779214145\n" + "\n" + "eyr:2022\n"
				+ "hcl:#6b5442 byr:1941 ecl:grn hgt:169cm iyr:2014\n" + "pid:610328167\n" + "\n"
				+ "iyr:2026 cid:179 pid:193cm\n" + "ecl:#deb37c\n" + "byr:1958 eyr:2024\n" + "hgt:185cm\n" + "\n"
				+ "pid:907508207 ecl:oth byr:1941 iyr:2017 hcl:#341e13\n" + "eyr:2030 hgt:186cm\n" + "\n"
				+ "iyr:2018 byr:1925\n" + "ecl:brn eyr:2023 pid:903196231\n" + "hgt:159cm\n" + "hcl:#a97842 cid:323\n"
				+ "\n" + "hgt:185cm ecl:hzl eyr:2022 iyr:2020 pid:572453155 hcl:#fffffd\n" + "\n"
				+ "hcl:#a97842 ecl:blu pid:#ab3597 eyr:1964 byr:2030\n" + "hgt:181cm iyr:2018\n" + "\n" + "ecl:blu\n"
				+ "hcl:#602927\n" + "cid:234\n" + "hgt:68in eyr:2021 pid:257420555 iyr:2014 byr:1972\n" + "\n"
				+ "hcl:#7d3b0c eyr:2022\n" + "hgt:152cm byr:1974\n" + "iyr:2017\n" + "pid:353127736\n" + "ecl:gry\n"
				+ "\n" + "iyr:2018 eyr:2028 byr:1924 hcl:#69929e ecl:gry\n" + "hgt:68in pid:942207567\n" + "\n"
				+ "eyr:2028 cid:90\n" + "hgt:185cm\n" + "ecl:amb byr:1990 pid:947625812 hcl:#623a2f iyr:2011\n" + "\n"
				+ "eyr:2023 byr:1996 hgt:175cm\n" + "iyr:2012\n" + "hcl:#866857 ecl:blu\n" + "pid:437669135\n" + "\n"
				+ "byr:1937 eyr:2030\n" + "hcl:#866857 iyr:2017 pid:513963895 hgt:157cm\n" + "ecl:grn\n" + "\n"
				+ "iyr:2016 hcl:#623a2f eyr:2025\n" + "pid:559150893 hgt:176cm\n" + "byr:1920 ecl:amb\n" + "\n"
				+ "byr:1982\n" + "eyr:1961 ecl:hzl\n" + "hgt:167cm hcl:#888785 iyr:2011 cid:261 pid:709006236\n" + "\n"
				+ "pid:307171649 byr:1935 hcl:#888785 hgt:182cm ecl:brn eyr:2030 iyr:2013\n" + "cid:256\n" + "\n"
				+ "ecl:hzl\n" + "eyr:1998\n" + "byr:2009\n" + "hgt:153cm iyr:2010\n" + "hcl:#888785 pid:140487128\n"
				+ "\n" + "iyr:2019 cid:78\n" + "hgt:169cm\n" + "hcl:#888785 ecl:hzl byr:1997 eyr:2028\n" + "\n"
				+ "hgt:182in eyr:2025 hcl:#cfa07d ecl:#27a1c9 byr:2005 pid:8143047758\n" + "\n" + "byr:2013 hgt:178in\n"
				+ "eyr:1933\n" + "pid:829007679 iyr:2016 hcl:#783308\n" + "ecl:grn\n" + "\n"
				+ "cid:267 byr:1930 pid:949963673 eyr:2026\n" + "ecl:grn iyr:2020\n" + "hgt:188cm hcl:#6b5442\n" + "\n"
				+ "eyr:2022 pid:254482159\n" + "byr:1935 iyr:2017\n" + "ecl:hzl\n" + "hcl:#b6652a\n" + "hgt:165cm\n"
				+ "\n" + "hcl:109d15 hgt:72cm\n" + "cid:258 byr:2023 eyr:1987 ecl:grt iyr:2022\n" + "\n" + "byr:1969\n"
				+ "ecl:oth hgt:151cm\n" + "pid:578662559\n" + "eyr:2024 iyr:2015 hcl:#602927\n" + "cid:343\n" + "\n"
				+ "iyr:2011 byr:1989\n" + "ecl:brn eyr:2029 pid:123354233\n" + "hcl:#efcc98\n" + "\n"
				+ "hcl:#a97842 iyr:2010 pid:558586208\n" + "eyr:2029 byr:2002 ecl:amb\n" + "cid:225 hgt:152cm\n" + "\n"
				+ "eyr:2005 byr:2024 iyr:1924 ecl:gmt cid:186 pid:#886ae9\n" + "hcl:3cf4cd hgt:74cm\n" + "\n"
				+ "ecl:gry\n" + "eyr:2029\n" + "iyr:2013\n" + "hgt:178cm hcl:#7d3b0c\n" + "\n"
				+ "byr:1970 hcl:#6b5442 hgt:155cm iyr:2020 ecl:hzl\n" + "pid:698123164 eyr:2030 cid:185\n" + "\n"
				+ "hcl:#6b5442 ecl:hzl\n" + "iyr:2014 cid:324 pid:149063285 hgt:64in eyr:2023\n" + "byr:1949\n" + "\n"
				+ "hcl:#866857\n" + "eyr:2025\n" + "iyr:2012 cid:116 hgt:185cm\n" + "pid:416329937\n"
				+ "ecl:grn byr:1962\n" + "\n" + "iyr:2020 cid:55 byr:1985 hcl:#733820 pid:237883033 eyr:2020 ecl:blu\n"
				+ "\n" + "iyr:2020 hgt:71in\n" + "ecl:hzl byr:1960 cid:53 hcl:#888785 pid:590574853 eyr:2024\n" + "\n"
				+ "pid:834729501 iyr:2019 hgt:72in byr:1977\n" + "hcl:#604861 ecl:oth eyr:2024\n" + "\n"
				+ "pid:111536282 ecl:gry\n" + "hgt:69in eyr:2021 byr:1940\n" + "iyr:2019\n" + "hcl:#ceb3a1\n" + "\n"
				+ "hgt:186cm pid:045765056 ecl:gry byr:1958 iyr:2012\n" + "eyr:2025 hcl:#cfa07d\n" + "\n"
				+ "hgt:61in eyr:2023 pid:4189258985 ecl:brn iyr:1995\n" + "hcl:#602927 byr:2017\n" + "\n"
				+ "byr:1984 hcl:#866857\n" + "iyr:2013 pid:927074474 hgt:168cm\n" + "eyr:2021 ecl:oth\n" + "\n"
				+ "hgt:186cm\n" + "pid:948677443 iyr:2014 hcl:#866857 byr:1968 ecl:amb eyr:2027\n" + "\n"
				+ "eyr:2028 cid:260 hcl:#623a2f pid:500330326\n" + "iyr:2018 hgt:170cm\n" + "ecl:gry\n" + "byr:1960\n"
				+ "\n" + "hgt:71cm\n" + "pid:6209572 byr:1927 iyr:2011 ecl:utc hcl:3bc47a eyr:1984\n" + "\n"
				+ "hgt:164cm cid:160 iyr:2010\n" + "byr:1922 eyr:2024 hcl:#c0946f ecl:gry pid:867476938\n" + "\n"
				+ "cid:316\n" + "iyr:2015 hcl:#b6652a hgt:72cm pid:#c37dbf byr:2022 eyr:2036 ecl:#8bd8f4\n" + "\n"
				+ "iyr:2016 hgt:172cm\n" + "pid:482664712 ecl:hzl eyr:2024 hcl:#602927 byr:1945\n" + "\n"
				+ "eyr:2029 pid:883381915\n" + "hgt:174cm byr:1937 hcl:#fffffd ecl:gry cid:91\n" + "\n"
				+ "eyr:2029 pid:302832265 hcl:#ceb3a1 byr:2010\n" + "hgt:64 iyr:1960\n" + "\n"
				+ "hgt:170cm eyr:2030 pid:846949920\n" + "hcl:#ceb3a1\n" + "ecl:hzl iyr:2016 byr:1945\n" + "\n"
				+ "hcl:#efcc98\n" + "pid:406029852 eyr:2023 byr:1981 ecl:blu iyr:2013\n" + "\n"
				+ "pid:788563693 hcl:#a97842 hgt:172cm eyr:2022 ecl:brn iyr:2010 byr:2002\n" + "\n" + "iyr:2013\n"
				+ "hgt:60cm hcl:#7d3b0c pid:6594060725 ecl:#46a7d7 eyr:2023 byr:1995\n" + "\n"
				+ "cid:313 byr:1964 pid:102442749 eyr:2020\n" + "hgt:167cm\n" + "hcl:#341e13\n" + "\n"
				+ "ecl:grn hgt:163cm pid:405504213 cid:349 hcl:#733820 eyr:2029 iyr:2011\n" + "\n"
				+ "ecl:hzl pid:470689685 iyr:2015 byr:1980 hgt:180cm eyr:2027\n" + "\n" + "eyr:2023 iyr:2013\n"
				+ "hgt:189cm hcl:#866857 byr:1981\n" + "cid:313\n" + "ecl:brn pid:386584267\n" + "\n" + "iyr:2011\n"
				+ "hcl:#7d3b0c\n" + "eyr:2027\n" + "ecl:gry byr:1931\n" + "hgt:71in\n" + "pid:435568613\n" + "\n"
				+ "eyr:2021\n" + "pid:443386140 hgt:192cm iyr:2015 byr:1974\n" + "\n" + "byr:1989 ecl:oth iyr:2011\n"
				+ "eyr:2027\n" + "pid:761106563 hcl:#efcc98\n" + "hgt:60in\n" + "\n"
				+ "byr:1933 ecl:brn pid:607926472\n" + "hcl:#cfa07d eyr:2026\n" + "iyr:2010\n" + "\n"
				+ "ecl:hzl eyr:2027 hgt:175cm\n" + "pid:68527368\n" + "byr:1980 iyr:2017 hcl:#341e13\n" + "\n"
				+ "hgt:159cm pid:6199921925 iyr:1920 byr:1950 ecl:amb cid:229 eyr:2034\n" + "\n"
				+ "pid:060780170 ecl:gmt\n" + "eyr:1961 hgt:184cm hcl:#a97842 byr:2007\n" + "\n"
				+ "eyr:2025 byr:1970 ecl:brn hgt:183cm pid:423232940 hcl:#cfa07d cid:283\n" + "\n"
				+ "hcl:#18171d hgt:191cm\n" + "byr:1951\n" + "eyr:2029\n" + "pid:627632195 cid:268 iyr:2012\n" + "\n"
				+ "eyr:2025 iyr:2019 hgt:163cm\n" + "ecl:oth pid:967756889\n" + "byr:1938\n" + "\n"
				+ "hgt:160cm iyr:2015\n" + "ecl:#9cf598 pid:297446459 cid:123 byr:1968 eyr:1970\n" + "hcl:#efcc98\n"
				+ "\n" + "ecl:hzl pid:311990731 hgt:171cm hcl:#602927 byr:1978\n" + "eyr:2026 cid:254 iyr:2014\n" + "\n"
				+ "hcl:#8e0dfc\n" + "pid:961997362 byr:1950 eyr:2027 hgt:184in ecl:blu iyr:2015 cid:266\n" + "\n"
				+ "pid:953859016 iyr:2018 hcl:#341e13 ecl:grn cid:61\n" + "hgt:192cm\n" + "eyr:2022 byr:1920\n" + "\n"
				+ "eyr:2026 pid:149020634 byr:1942 iyr:2021 hcl:#6b5442\n" + "ecl:oth hgt:176in\n" + "\n"
				+ "eyr:2025 hgt:176cm\n" + "iyr:2020 ecl:oth hcl:#efcc98 pid:196082064 byr:2002\n" + "\n"
				+ "hgt:172in hcl:z\n" + "pid:#b454a0\n" + "ecl:#d7a600\n" + "byr:1977\n" + "eyr:2035 iyr:2014\n" + "\n"
				+ "cid:254 iyr:2020\n" + "pid:716596533\n" + "hcl:#341e13 byr:1947\n" + "hgt:150cm ecl:hzl eyr:2028\n"
				+ "\n" + "iyr:2019 pid:190601635 byr:1922 hcl:#18171d hgt:71in ecl:brn eyr:2021\n" + "\n"
				+ "byr:1938 iyr:2019 eyr:2028 pid:568504071 hcl:#efcc98 hgt:178cm ecl:amb\n" + "\n"
				+ "pid:921417345 eyr:2020 ecl:brn hcl:#c0946f\n" + "hgt:168cm\n" + "byr:1983 cid:170\n" + "iyr:2018\n"
				+ "\n" + "iyr:2020 cid:212 eyr:2002 pid:61850316 hgt:148 hcl:#b6652a\n" + "byr:2024 ecl:grn\n" + "\n"
				+ "hcl:z eyr:1985 iyr:2015 hgt:72cm ecl:brn pid:599880521\n" + "\n" + "pid:166cm hcl:z\n"
				+ "hgt:165 eyr:2036\n" + "cid:152 iyr:1943\n" + "ecl:zzz\n" + "\n" + "eyr:2021 iyr:2014\n"
				+ "hgt:156cm\n" + "pid:654181902 ecl:amb\n" + "byr:1946\n" + "hcl:#733820\n" + "\n" + "iyr:2019\n"
				+ "hgt:189cm byr:1940 pid:419593669 ecl:amb\n" + "cid:149 hcl:#fffffd eyr:2020\n" + "\n" + "hgt:172cm\n"
				+ "ecl:lzr pid:788208394 hcl:#341e13 cid:183\n" + "iyr:2020 eyr:2027 byr:1988\n" + "\n"
				+ "byr:2030 ecl:#d82c54 iyr:2014\n" + "hcl:#be9be7 eyr:2027 pid:1291285950 hgt:61cm\n" + "\n"
				+ "ecl:hzl\n" + "hcl:#a97842 hgt:186cm byr:1992 eyr:2022\n" + "\n"
				+ "iyr:2017 hgt:191cm pid:097984693 eyr:2025 byr:1963\n" + "cid:333\n" + "ecl:blu\n" + "\n"
				+ "ecl:zzz pid:425594420\n" + "byr:1983\n" + "hcl:z\n" + "eyr:2028 hgt:184cm\n" + "iyr:1937\n" + "\n"
				+ "hgt:167cm\n" + "eyr:2025 hcl:#623a2f pid:575911832\n" + "cid:305 byr:1939 iyr:2020\n" + "\n"
				+ "iyr:2015 hgt:179cm hcl:d678e0 byr:2030 pid:284187009 eyr:1977 cid:285\n" + "\n"
				+ "pid:405789549 byr:1982 eyr:2020 hcl:#623a2f\n" + "hgt:161cm iyr:2013 ecl:amb\n" + "\n"
				+ "pid:775860836 hgt:184cm hcl:#fffffd ecl:amb byr:1930 eyr:2022 iyr:2016\n" + "\n"
				+ "iyr:2020 byr:1979\n" + "eyr:2024 hgt:171cm\n" + "ecl:brn hcl:#ceb3a1 pid:853915000\n" + "\n"
				+ "iyr:2015 pid:244459567\n" + "hcl:#18171d cid:224 byr:1931 eyr:2022 hgt:169cm ecl:gry\n" + "\n"
				+ "iyr:2017 cid:308 eyr:2026 ecl:blu hgt:59in byr:1953\n" + "hcl:#ceb3a1 pid:466915764\n" + "\n"
				+ "hcl:#7d3b0c\n" + "byr:1940 iyr:2015\n" + "eyr:2020 pid:950614940 ecl:amb\n" + "hgt:179cm\n" + "\n"
				+ "byr:2010\n" + "cid:106 eyr:2022\n" + "iyr:2020 pid:336057617 ecl:brn hcl:f13e26\n" + "hgt:182cm\n"
				+ "\n" + "byr:1981 iyr:2017 hgt:152cm\n" + "hcl:#fffffd\n" + "eyr:2024 ecl:gry\n" + "\n"
				+ "cid:216 hgt:193cm\n" + "byr:1975 ecl:oth pid:684529055 iyr:2018 eyr:2020 hcl:#18171d\n" + "\n"
				+ "hgt:150cm\n" + "eyr:2028\n" + "hcl:#cfa07d ecl:grn\n" + "iyr:2018 byr:1951 pid:749102509\n" + "\n"
				+ "pid:937451204 hcl:#341e13 iyr:2020\n" + "hgt:171cm eyr:2021\n" + "byr:1941\n" + "ecl:hzl\n" + "\n"
				+ "cid:69\n" + "iyr:2014 eyr:2022 pid:174789690 hgt:157cm byr:1961 ecl:hzl\n" + "hcl:#a97842\n" + "\n"
				+ "hcl:#7d3b0c pid:658134059 hgt:65in byr:2005 ecl:#2dcb50 iyr:2012\n" + "eyr:2030\n" + "\n"
				+ "eyr:2027\n" + "hgt:68in ecl:oth hcl:#888785 iyr:2016 pid:181577931\n" + "\n" + "iyr:1997 byr:1994\n"
				+ "hgt:189cm\n" + "ecl:gry pid:564165515\n" + "eyr:2029 hcl:#ceb3a1\n" + "\n" + "hcl:#602927 eyr:2024\n"
				+ "cid:130\n" + "iyr:2015 ecl:blu\n" + "hgt:184cm byr:1996\n" + "pid:897871188\n" + "\n"
				+ "ecl:oth hcl:#623a2f\n" + "iyr:2016 pid:012591439 byr:1937 eyr:2022 hgt:176cm\n" + "\n" + "eyr:2020\n"
				+ "byr:1965\n" + "iyr:2013 hgt:193cm\n" + "hcl:#ceb3a1\n" + "ecl:hzl pid:177120440\n" + "\n"
				+ "byr:1934 iyr:2015 hcl:#341e13\n" + "pid:370860309 ecl:oth\n" + "eyr:2028 hgt:157cm\n" + "\n"
				+ "ecl:brn\n" + "byr:2001\n" + "iyr:2010\n" + "eyr:2028 hcl:#866857 hgt:183cm pid:194361427\n" + "\n"
				+ "hgt:182cm pid:449667574 ecl:amb\n" + "byr:1958 iyr:2017\n" + "hcl:#efcc98\n" + "\n"
				+ "iyr:2020 ecl:hzl eyr:2030 hgt:185cm byr:1969 hcl:#ceb3a1 pid:157651787\n" + "\n"
				+ "pid:893956434 eyr:2027 hgt:185cm hcl:#a97842\n" + "byr:1944 ecl:oth\n" + "\n" + "byr:2011\n"
				+ "iyr:2018\n" + "hcl:#623a2f hgt:159cm ecl:blu pid:174cm\n" + "eyr:2030\n" + "\n"
				+ "ecl:grt pid:520129782 eyr:2020\n" + "byr:2020 hcl:z cid:50 iyr:2017\n" + "hgt:156cm\n" + "\n"
				+ "iyr:2015\n" + "ecl:grn hcl:#83b224 eyr:2021 pid:554994156 hgt:179cm byr:1994\n" + "\n"
				+ "ecl:gry byr:1971 pid:772131254\n" + "eyr:2027 cid:201 hcl:#602927\n" + "\n" + "cid:125\n"
				+ "byr:1943 hgt:168cm ecl:hzl pid:418786991\n" + "eyr:2020 iyr:2016\n" + "hcl:#cfa07d\n" + "\n"
				+ "pid:825704567 eyr:2032 byr:2024\n" + "iyr:1926\n" + "hcl:d31139 hgt:190in\n" + "\n"
				+ "cid:243 hcl:#cfa07d byr:1951 ecl:oth pid:382615614\n" + "iyr:2018 eyr:2030 hgt:64in\n" + "\n"
				+ "byr:1925 hgt:187cm ecl:oth eyr:2023 hcl:#888785\n" + "\n"
				+ "eyr:2028 iyr:2013 ecl:brn byr:1923 cid:174 hcl:#b6652a hgt:154cm pid:274036240\n" + "\n"
				+ "ecl:brn hgt:183cm iyr:2016\n" + "byr:1922\n" + "hcl:#efcc98 eyr:2030\n" + "\n" + "hgt:188cm\n"
				+ "byr:1979\n" + "ecl:amb\n" + "eyr:2025 hcl:#b6652a cid:130\n" + "pid:646985829 iyr:2019\n" + "\n"
				+ "hgt:76cm hcl:z cid:112 ecl:zzz\n" + "pid:953385473 eyr:2020\n" + "byr:1943\n" + "\n"
				+ "ecl:#12c807\n" + "byr:1954 eyr:1934 hgt:73cm hcl:#ceb3a1 iyr:2015 pid:704621520\n" + "\n"
				+ "hgt:188cm hcl:#733820 eyr:2024 ecl:grn\n" + "iyr:2018 byr:1982 pid:522812862\n" + "\n"
				+ "hgt:68cm ecl:blu\n" + "byr:2023 pid:875418461 iyr:2021 eyr:2020 hcl:#623a2f\n" + "\n" + "byr:1967\n"
				+ "pid:313706535 ecl:amb hcl:#888785\n" + "iyr:2012\n" + "eyr:2026\n" + "\n" + "eyr:2026\n"
				+ "pid:288363970 cid:70 byr:1932 hgt:157cm iyr:2016 ecl:hzl hcl:#ceb3a1\n" + "\n"
				+ "byr:1992 pid:539896055\n" + "eyr:2023\n" + "cid:189 hgt:70in ecl:oth iyr:2019\n" + "hcl:#866857\n"
				+ "\n" + "hgt:158in\n" + "ecl:gry byr:2028\n" + "eyr:2036 cid:188\n" + "hcl:#cfa07d\n"
				+ "pid:044279141\n" + "\n" + "eyr:2024 hgt:170cm ecl:hzl\n" + "byr:1939 pid:851235247 iyr:2013\n"
				+ "hcl:#fffffd\n" + "\n" + "ecl:hzl hcl:#c0946f\n" + "hgt:167cm\n"
				+ "eyr:2024 byr:1936 pid:463230636 cid:297\n" + "iyr:2016\n" + "\n"
				+ "pid:291401545 ecl:grn hcl:#b6652a iyr:2014\n" + "hgt:185cm eyr:2025 byr:1947\n" + "\n"
				+ "eyr:2029 pid:612595763\n" + "iyr:2018 ecl:gry\n" + "cid:290\n" + "byr:1991 hcl:#733820\n"
				+ "hgt:150cm\n" + "\n" + "hgt:151cm\n" + "pid:667532675 cid:134\n" + "byr:1930\n"
				+ "hcl:#efcc98 iyr:2012\n" + "ecl:oth\n" + "\n" + "ecl:gry\n" + "hcl:#888785 hgt:161cm\n" + "eyr:2023\n"
				+ "pid:467759498 cid:274\n" + "\n"
				+ "eyr:2023 byr:1956 hgt:188cm iyr:2014 hcl:#b6652a pid:382721925 ecl:brn\n" + "\n"
				+ "byr:1947 ecl:gry eyr:2020\n" + "pid:874004905 hcl:#602927 hgt:161cm iyr:2029\n" + "\n"
				+ "pid:164334257\n" + "iyr:2014 cid:286 eyr:2020\n" + "hcl:#733820\n" + "ecl:gry byr:1959 hgt:165cm\n"
				+ "\n" + "hgt:59in\n" + "pid:#5b1362\n" + "eyr:2028 iyr:1980 hcl:z byr:2030\n" + "ecl:utc\n" + "\n"
				+ "pid:604128460 iyr:2016 byr:1952 hgt:152cm ecl:grn hcl:#7d3b0c eyr:2021\n" + "\n"
				+ "pid:7483106309 eyr:2005 hgt:158in byr:2024 iyr:1935 hcl:z\n" + "ecl:#158994\n" + "\n"
				+ "hcl:22207f eyr:1994\n" + "cid:166 pid:#d8e64c ecl:utc\n" + "byr:1966 hgt:70cm\n" + "iyr:1980\n"
				+ "\n" + "iyr:2012 pid:045892410 hgt:70in ecl:dne hcl:1a323a byr:1920 eyr:2022\n" + "\n"
				+ "hcl:#18171d iyr:2019 eyr:2026\n" + "hgt:191cm pid:514596186 cid:327 byr:1938 ecl:grn\n" + "\n"
				+ "pid:904148746 hcl:#a97842 hgt:161cm\n" + "cid:181\n" + "iyr:2012 eyr:2020 ecl:oth\n" + "\n"
				+ "iyr:2028\n" + "eyr:2034\n" + "cid:276 pid:#0e7ee2 byr:2020\n" + "hgt:63cm ecl:gry\n" + "hcl:z\n"
				+ "\n" + "pid:4270554593 eyr:2031 ecl:lzr hgt:72cm\n" + "iyr:2027 hcl:ffc210 cid:132\n" + "byr:2008\n"
				+ "\n" + "iyr:2018 pid:174cm cid:144\n" + "ecl:#10b2ed byr:1931 eyr:2040 hcl:z hgt:68in\n" + "\n"
				+ "pid:446746712\n" + "iyr:1957\n" + "ecl:oth cid:213 hgt:184cm byr:2008 hcl:z\n" + "\n"
				+ "hcl:#7d3b0c iyr:2012 ecl:hzl\n" + "eyr:2023 pid:270148060\n" + "\n" + "pid:832184923\n"
				+ "eyr:2023 hgt:180cm\n" + "byr:1965 ecl:hzl cid:189 hcl:#a97842\n" + "iyr:2016\n" + "\n"
				+ "pid:688867083\n" + "iyr:2011 hcl:#733820 cid:147 eyr:2021\n" + "byr:1986 ecl:oth\n" + "\n"
				+ "hgt:166in ecl:amb byr:2014\n" + "pid:169cm hcl:#cfa07d iyr:1976\n" + "\n"
				+ "hgt:64in byr:1987 hcl:01f3d7\n" + "pid:553206412 eyr:2027 ecl:grn cid:336\n" + "iyr:2012\n" + "\n"
				+ "cid:336\n" + "ecl:oth byr:1975\n" + "pid:296100726 hcl:#6b5442 iyr:2016 hgt:180cm eyr:2029\n" + "\n"
				+ "hcl:#ceb3a1 hgt:181cm pid:364719801 byr:1922 eyr:2029\n" + "iyr:2010 cid:346 ecl:gry\n" + "\n"
				+ "hcl:#1c7f1d cid:205\n" + "hgt:184cm\n" + "byr:1928\n" + "pid:694275035 iyr:2018 ecl:blu eyr:2023\n"
				+ "\n" + "eyr:1970\n" + "hcl:z byr:2001\n" + "pid:9244596 iyr:2030 hgt:187in ecl:blu\n" + "\n"
				+ "hgt:96\n" + "byr:2030 ecl:zzz eyr:1920 pid:115437655 hcl:z\n" + "iyr:2017\n" + "cid:344\n" + "\n"
				+ "iyr:2018\n" + "eyr:2023\n" + "hcl:#888785 hgt:188cm\n" + "ecl:amb byr:1992 pid:602211075\n" + "\n"
				+ "pid:848099019 hgt:168cm iyr:2016\n" + "eyr:2026 ecl:amb\n" + "hcl:#866857 byr:1981\n" + "\n"
				+ "iyr:2013 hcl:#623a2f hgt:151cm cid:135 byr:1974 eyr:2026 ecl:gry\n" + "pid:313553018\n" + "\n"
				+ "hcl:#733820\n" + "byr:1986 hgt:182cm\n" + "ecl:brn eyr:2024 iyr:2017\n" + "pid:676008782\n" + "\n"
				+ "eyr:2030 pid:833874339 iyr:2011 byr:1949 hgt:159cm\n" + "ecl:brn hcl:#602927\n" + "\n"
				+ "hgt:182cm hcl:#6b5442 pid:131549376 eyr:2029 iyr:2012\n" + "ecl:gry byr:1926\n" + "\n"
				+ "cid:55 ecl:amb iyr:2015 hgt:192cm hcl:#a97842\n" + "byr:1944\n" + "eyr:2027\n" + "\n"
				+ "iyr:1944 eyr:2038 hcl:a2adf2 cid:99 byr:2006 hgt:67cm\n" + "pid:154cm\n" + "ecl:dne\n" + "\n"
				+ "eyr:2005 hcl:#1495bd ecl:grt byr:2028\n" + "iyr:2016 hgt:155 pid:182cm\n" + "cid:326\n" + "\n"
				+ "hgt:136\n" + "pid:599182089 eyr:2020 byr:1945\n" + "iyr:2012\n" + "ecl:oth hcl:#18171d\n" + "\n"
				+ "pid:4695182580\n" + "iyr:2012\n" + "ecl:brn eyr:2039 byr:1936\n" + "hcl:#cfa07d\n" + "\n"
				+ "ecl:hzl byr:1949 cid:133 hgt:159cm hcl:#b6652a pid:9833212692 iyr:2011 eyr:2030\n" + "\n"
				+ "eyr:2020\n" + "hgt:175cm\n" + "cid:140 iyr:2014 byr:1980 hcl:#7d3b0c\n" + "ecl:grn pid:400508366\n"
				+ "\n" + "pid:#100a75 iyr:2016\n" + "hgt:65\n" + "eyr:2037 ecl:hzl\n" + "byr:1962\n" + "\n"
				+ "eyr:2024 pid:180cm hcl:#6b5442 hgt:154cm\n" + "iyr:1964\n" + "\n" + "byr:1986 hgt:159cm ecl:brn\n"
				+ "pid:856817592 hcl:#cfa07d eyr:2024\n" + "iyr:2017\n" + "\n" + "hgt:166cm\n"
				+ "byr:1996 hcl:#410645\n" + "ecl:hzl iyr:2010 cid:178 pid:337713295\n" + "eyr:2026\n" + "\n"
				+ "iyr:2017 byr:1964 hgt:167cm hcl:#7d3b0c cid:298 ecl:brn pid:371416367\n" + "\n"
				+ "byr:1929 iyr:2011 hcl:#fffffd ecl:blu\n" + "pid:013408674 hgt:187cm eyr:2021\n" + "\n"
				+ "hcl:#cfa07d byr:1986 cid:331\n" + "iyr:2010 ecl:gry pid:616063053 hgt:150cm\n" + "eyr:2028\n" + "\n"
				+ "pid:013835033 iyr:2017 byr:1991\n" + "hgt:154cm hcl:#efcc98 eyr:2020\n" + "\n"
				+ "byr:1978 eyr:2024\n" + "hgt:155cm iyr:2012 hcl:#694989 pid:914726069\n" + "ecl:amb\n" + "\n"
				+ "ecl:blu pid:139464317 hcl:#fffffd eyr:2024 byr:1970 hgt:72in iyr:2012\n" + "\n"
				+ "byr:1965 hcl:#ceb3a1 ecl:hzl iyr:2019 pid:910593212 eyr:2029\n" + "\n" + "byr:1994 cid:228\n"
				+ "ecl:grn hgt:171cm pid:538884417 eyr:2025 iyr:2011 hcl:#6b5442\n" + "\n" + "cid:264 hcl:#623a2f\n"
				+ "hgt:186cm iyr:2012 ecl:brn eyr:2024 pid:304101929 byr:1954\n" + "\n"
				+ "hgt:183cm byr:1987 hcl:z ecl:gry eyr:2020 pid:384983241 iyr:2015\n" + "\n" + "pid:#885c1a\n"
				+ "byr:2012 eyr:2034 ecl:#8ea705 iyr:2028 hgt:61cm hcl:z\n" + "\n"
				+ "eyr:2023 hgt:156cm byr:1939 hcl:#cd2220 ecl:brn pid:484163297\n" + "\n" + "hgt:158in\n"
				+ "byr:2000 ecl:lzr\n" + "iyr:2014\n" + "eyr:2033 pid:50157400\n" + "\n" + "byr:1974 hcl:#c0946f\n"
				+ "iyr:2018 pid:285451524 cid:299 eyr:2029 hgt:184cm ecl:hzl\n" + "\n"
				+ "byr:1974 hcl:#602927 hgt:151cm iyr:2013 pid:322935162 ecl:amb\n" + "cid:209\n" + "eyr:2026\n" + "\n"
				+ "hcl:#341e13 iyr:2015\n" + "ecl:gry byr:1970\n" + "hgt:186cm\n" + "pid:330151070 eyr:2034\n" + "\n"
				+ "ecl:gry eyr:2023\n" + "hgt:160cm hcl:#c0946f\n" + "iyr:2011 byr:1926 pid:727347794\n" + "\n"
				+ "iyr:2012\n" + "byr:1974 hcl:#866857\n" + "eyr:2025\n" + "pid:933155590 hgt:167cm\n" + "ecl:grn\n"
				+ "\n" + "iyr:2015 ecl:gry eyr:2029\n" + "byr:1967 hcl:#f9f576 hgt:170cm pid:439696954 cid:173\n" + "\n"
				+ "eyr:2029 byr:1935 ecl:brn pid:165587982\n" + "hcl:#6b5442\n" + "iyr:2020\n" + "\n"
				+ "eyr:2029 ecl:hzl hcl:#866857 byr:1994\n" + "pid:308548232 hgt:162cm iyr:2012\n" + "\n"
				+ "byr:1924 cid:274\n" + "pid:028266367 eyr:2025 iyr:2017 hgt:169cm\n" + "hcl:#cfa07d ecl:gry\n" + "\n"
				+ "eyr:2025 byr:1995\n" + "ecl:brn\n" + "hgt:160cm\n" + "pid:819047484\n" + "hcl:#602927 iyr:2011\n"
				+ "\n" + "pid:660383456\n" + "iyr:2016 eyr:2022 hgt:158cm byr:1942 ecl:amb cid:334 hcl:#efcc98\n" + "\n"
				+ "hcl:#6b5442 iyr:2024 cid:180 ecl:grn pid:167cm hgt:169\n" + "\n"
				+ "eyr:2024 iyr:2017 hgt:165cm hcl:#7d3b0c byr:1920\n" + "ecl:amb pid:236377188\n" + "\n"
				+ "pid:063113952\n" + "ecl:grn hcl:#341e13 hgt:166cm\n" + "byr:1977 iyr:2017\n" + "\n"
				+ "ecl:amb hgt:174cm\n" + "eyr:2028 byr:2002\n" + "hcl:#7d3b0c\n" + "pid:428826816 iyr:2017\n" + "\n"
				+ "byr:2025 ecl:dne hgt:167in pid:706379338\n" + "iyr:2019 hcl:240e75 eyr:1971\n" + "\n" + "eyr:2021\n"
				+ "hcl:#efcc98 iyr:2014\n" + "pid:358236477\n" + "byr:1923 cid:73 hgt:165cm ecl:amb\n" + "\n"
				+ "eyr:2030 cid:267\n" + "ecl:brn\n" + "pid:282023612 hcl:#c0946f iyr:2018 byr:1989\n" + "hgt:72cm\n"
				+ "\n" + "ecl:utc hcl:ea4b34 byr:2013\n" + "pid:#d58d54\n" + "hgt:107 iyr:2027 cid:296 eyr:2038\n"
				+ "\n" + "byr:1946 eyr:2024 iyr:2012\n" + "hcl:#341e13\n" + "pid:765835791 hgt:159cm\n" + "\n"
				+ "hcl:#341e13 byr:1927\n" + "ecl:grn iyr:2011\n" + "hgt:175cm eyr:2023 pid:638808763 cid:339\n" + "\n"
				+ "eyr:2030 cid:160 byr:1994 hgt:163cm ecl:hzl iyr:2016 hcl:#623a2f pid:569304871\n" + "\n"
				+ "byr:1965\n" + "eyr:2020 hgt:157cm hcl:#a97842\n" + "cid:271 iyr:2014 pid:326802068 ecl:#a16571\n"
				+ "\n" + "byr:1965\n" + "ecl:hzl eyr:2029 iyr:2010 hgt:157cm\n" + "hcl:#7d3b0c pid:617693914\n" + "\n"
				+ "pid:547158528 byr:1956\n" + "ecl:gry hgt:189cm\n" + "eyr:2029\n" + "hcl:#602927\n" + "iyr:2011\n"
				+ "\n" + "hcl:#efcc98\n" + "ecl:#1ecd0e pid:160cm eyr:2027 hgt:183cm byr:2027 iyr:1963\n" + "\n"
				+ "hcl:#fffffd eyr:2021 iyr:2014 byr:1959 ecl:amb\n" + "pid:102521439 hgt:190cm\n" + "\n"
				+ "cid:112 hcl:#fffffd byr:2025\n" + "pid:016603375\n" + "eyr:1942 hgt:145\n" + "iyr:1994\n" + "\n"
				+ "ecl:xry\n" + "pid:#5be367\n" + "hgt:171cm cid:144 iyr:1946 eyr:2034 hcl:z byr:2022\n" + "\n"
				+ "ecl:oth\n" + "iyr:2014 hcl:#7d3b0c\n" + "cid:316\n" + "byr:1936 pid:088295340\n" + "eyr:2029\n"
				+ "\n" + "iyr:2019\n" + "hgt:183cm ecl:brn hcl:#efcc98 pid:821190245 cid:251 eyr:2023\n" + "byr:1993\n"
				+ "\n" + "ecl:oth iyr:2018\n" + "cid:131\n" + "hcl:#524e2e byr:1981 hgt:183cm eyr:2022 pid:037981572\n"
				+ "\n" + "hcl:#18171d byr:1934 eyr:2020 hgt:62in\n" + "cid:64\n" + "ecl:oth pid:343039563 iyr:2010\n"
				+ "\n" + "hcl:#733820 pid:374199356\n" + "hgt:169cm eyr:2026 byr:1994 iyr:2015 ecl:brn\n" + "\n"
				+ "pid:394267581\n" + "hcl:#a97842 iyr:2010 byr:1988\n" + "hgt:185cm ecl:amb\n" + "eyr:2022\n" + "\n"
				+ "ecl:#be3b70 iyr:2025\n" + "hcl:z\n" + "eyr:2010\n" + "byr:2023\n" + "hgt:65 cid:220 pid:#d6af49\n"
				+ "\n" + "eyr:2029\n" + "hcl:#a97842 ecl:amb hgt:159cm\n" + "cid:228 byr:1946 iyr:2012\n"
				+ "pid:805319194\n" + "\n" + "hcl:#c0946f eyr:2020 hgt:171cm ecl:oth iyr:2010 byr:1958 pid:276122958\n"
				+ "\n" + "iyr:2017\n" + "hcl:#da47a1 byr:2007 ecl:utc\n" + "eyr:1945 cid:327 hgt:192cm pid:549704477\n"
				+ "\n" + "iyr:1923 hgt:174in hcl:z byr:1974\n" + "eyr:2026\n" + "ecl:xry pid:158cm\n" + "\n"
				+ "iyr:2022\n" + "ecl:#ae10f9\n" + "hgt:108\n" + "eyr:2035 hcl:z byr:2019 pid:#1f4f7c\n" + "\n"
				+ "eyr:2021 pid:959352732 cid:306 hgt:178cm ecl:amb\n" + "iyr:2012\n" + "byr:1953\n" + "\n"
				+ "byr:2016 ecl:lzr eyr:2021 hcl:z iyr:1977 hgt:181cm cid:164\n" + "\n"
				+ "cid:242 byr:2008 hcl:#866857 hgt:172cm iyr:2011\n" + "ecl:blu eyr:2026 pid:350658669\n" + "\n"
				+ "hgt:67in eyr:2030\n" + "ecl:gry pid:156329184 iyr:2010 byr:1936 hcl:#efcc98\n" + "\n"
				+ "cid:110 hgt:76in iyr:2018\n" + "eyr:2029 pid:474249956 byr:2002 hcl:#866857\n" + "ecl:oth\n" + "\n"
				+ "iyr:2016 hgt:193cm eyr:2029\n" + "byr:1934 hcl:#b6652a pid:901756621\n" + "ecl:brn\n" + "\n"
				+ "eyr:2017 hcl:z pid:#2f9848 iyr:2024\n" + "hgt:170cm\n" + "\n"
				+ "hgt:60in eyr:2026 byr:1922 hcl:#18171d iyr:2016\n" + "pid:921038878";
		String rawPuzzleValid = "pid:087499704 hgt:74in ecl:grn iyr:2012 eyr:2030 byr:1980\n" + "hcl:#623a2f\n" + "\n"
				+ "eyr:2029 ecl:blu cid:129 byr:1989\n" + "iyr:2014 pid:896056539 hcl:#a97842 hgt:165cm\n" + "\n"
				+ "hcl:#888785\n" + "hgt:164cm byr:2001 iyr:2015 cid:88\n" + "pid:545766238 ecl:hzl\n" + "eyr:2022\n"
				+ "\n" + "iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719";

		String rawPuzzleInvalid = "eyr:1972 cid:100\n" + "hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926\n"
				+ "\n" + "iyr:2019\n" + "hcl:#602927 eyr:1967 hgt:170cm\n" + "ecl:grn pid:012533040 byr:1946\n" + "\n"
				+ "hcl:dab227 iyr:2012\n" + "ecl:brn hgt:182cm pid:021572410 eyr:2020 byr:1992 cid:277\n" + "\n"
				+ "hgt:59cm ecl:zzz\n" + "eyr:2038 hcl:74454a iyr:2023\n" + "pid:3556412378 byr:2007";

		
		// byr:1946 eyr:2024 iyr:2012 hcl:#341e13 pid:765835791 hgt:159cm chybí ecl
		// 
		
		
		rawPuzzle = rawPuzzle.replace("\n", " ");
		// System.out.println(rawPuzzle);
		puzzle = rawPuzzle.split("  ");

		for (String person : puzzle) {
			// var = var.replace("\n", "").replace("\r", "");
			System.out.println("Person: " + person);

			String[] data = person.split(" ");
			for (String var2 : data) {
				// System.out.print("Data: " + var2);
				if (person.contains("byr") && var2.contains("byr")) {
					if (isBirthYearValid(var2))
						validData++;
					// System.out.println("byr -> OK");
				} else if (person.contains("iyr") && var2.contains("iyr")) {
					if (isIssueYearValid(var2))
						validData++;
					// System.out.println("iyr -> OK");
					else
						System.out.println("eyr -> NOT OK");
				} else if (person.contains("eyr") && var2.contains("eyr")) {
					if (isExpirationYearValid(var2))
						validData++;
					// System.out.println("eyr -> OK");
					else
						System.out.println("eyr -> NOT OK");
				} else if (person.contains("hgt") && var2.contains("hgt")) {
					if (isHeightValid(var2))
						validData++;
					// System.out.println("hgt -> OK");
					else
						System.out.println("hgt -> NOT OK");
				} else if (person.contains("hcl") && var2.contains("hcl")) {
					if (isHairColorValid(var2))
						validData++;
					// System.out.println("hcl -> OK");
					else
						System.out.println("hcl -> NOT OK");
				} else if (person.contains("ecl") && var2.contains("ecl")) {
					if (isEyeColorValid(var2))
						validData++;
					// System.out.println("ecl -> OK");
					else
						System.out.println("ecl -> NOT OK");
				} else if (person.contains("pid") && var2.contains("pid")) {
					if (isPassportIdValid(var2))
						validData++;
					// System.out.println("pid -> OK");

					else
						System.out.println("pid -> NOT OK");
				}
			}
			// System.out.println("Validních pasů je: " + validPass);
			if (validData == 7) {
				validPass++;
				validPasswordsSet.add(person);
				System.out.println("SPRÁVNĚĚĚĚĚĚĚĚĚĚĚ");
			}
			validData = 0;

			
			System.out.println("Validních hesel je: " + validPass);
			//System.out.println(validPasswordsSet);
			System.out.println("______________");

		}
	}

	// pid (Passport ID) - a nine-digit number, including leading zeroes.
	private static boolean isPassportIdValid(String var2) {
		boolean valid = false;
		System.out.println(var2.split(":")[1].length());
		
		try {
			Double num = Double.parseDouble(var2.split(":")[1]);
			//System.out.println(num);
		} catch (NumberFormatException e) {
			valid = false;
		}
		
		if (var2.split(":")[1].length() == 9) valid = true;
		
		return valid;
	}

	// ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
	private static boolean isEyeColorValid(String var2) {
		Set<String> set = new HashSet<String>();

		set.add("amb");
		set.add("blu");
		set.add("brn");
		set.add("gry");
		set.add("grn");
		set.add("hzl");
		set.add("oth");

		if (set.contains(var2.split(":")[1]))
			return true;
		return false;
	}

	// hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
	private static boolean isHairColorValid(String var2) {
		var2 = var2.split(":")[1];

		Pattern pattern = Pattern.compile("#[0-9a-f]{6}");
		Matcher matcher = pattern.matcher(var2);
		if (matcher.matches())
			return true;

		return false;
	}

	// hgt (Height) - a number followed by either cm or in:
	// If cm, the number must be at least 150 and at most 193.
	// If in, the number must be at least 59 and at most 76.
	private static boolean isHeightValid(String var2) {
		if (var2.substring(var2.length() - 2, var2.length()).equals("cm")) {
			// System.out.println(Integer.parseInt(var2.split(":")[1].replace("cm","")));
			if (Integer.parseInt(var2.split(":")[1].replace("cm", "")) >= 150
					&& Integer.parseInt(var2.split(":")[1].replace("cm", "")) <= 193)
				return true;
		} else if (Integer.parseInt(var2.split(":")[1].replace("in", "")) >= 59
				&& Integer.parseInt(var2.split(":")[1].replace("in", "")) <= 76)
			return true;

		return false;
	}

	// eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
	private static boolean isExpirationYearValid(String var2) {
		if (Integer.parseInt(var2.split(":")[1]) >= 2020 && (Integer.parseInt(var2.split(":")[1]) <= 2030))
			return true;
		return false;
	}

	// iyr (Issue Year) - four digits; at least 2010 and at most 2020.
	private static boolean isIssueYearValid(String var2) {
		if (Integer.parseInt(var2.split(":")[1]) >= 2010 && (Integer.parseInt(var2.split(":")[1])) <= 2020)
			return true;
		return false;
	}

	// byr (Birth Year) - four digits; at least 1920 and at most 2002.
	private static boolean isBirthYearValid(String var2) {
		if (Integer.parseInt(var2.split(":")[1]) >= 1920 && Integer.parseInt(var2.split(":")[1]) <= 2002)
			return true;
		return false;
	}

}
