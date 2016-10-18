package io.github.accessun.string;

import org.junit.Test;

public class GenerateSedRegex {

    public String generateSedRegex(String[] titles, String filename) {
        if (titles == null || titles.length == 0)
            return "";
        
        int columnNumber = titles.length;
        StringBuilder sb = new StringBuilder("sed -e '1 d' -e '1,$s/^");
        
        for (int i = 0; i < columnNumber - 1; i++) {
            sb.append("\\([^\\t]\\+\\)\\t");
        }
        sb.append("\\([^\\t]\\+\\)$/\\{ ");
        
        for (int i = 0; i < columnNumber - 1; i++) {
            sb.append("\"").append(titles[i]).append("\": \"\\").append(i + 1).append("\", ");
        }
        sb.append("\"").append(titles[columnNumber - 1]).append("\": \"\\").append(columnNumber).append("\" \\}/g'");
        sb.append(" -e 's/$/,/'").append(" -e '$s/,$//' ");
        sb.append(filename);
        sb.append(" | sed -e '1i[' -e '$a]'");
        return sb.toString();
    }
    
    @Test
    public void testGenerateSedRegex() {
        String[] titles = {"Proto", "Recv-Q", "Send-Q", "Local-Address", "Foreign-Address", "State"};
        String result = generateSedRegex(titles, "netstat.txt");
        System.out.println(result);
    }
    
    @Test
    public void testSplit() {
        String original = "Chr  Start   End Ref Alt phastConsElements46way  Func.refGene    Gene.refGene  "
                + "GeneDetail.refGene  ExonicFunc.refGene  AAChange.refGene    cytoBand    genomicSuperDups  "
                + "esp6500siv2_all 1000g2014oct_all    snp138  SIFT_score  SIFT_pred   Polyphen2_HDIV_score  "
                + "Polyphen2_HDIV_pred Polyphen2_HVAR_score    Polyphen2_HVAR_pred LRT_score   LRT_pred  "
                + "MutationTaster_score    MutationTaster_pred MutationAssessor_score  MutationAssessor_pred "
                + "FATHMM_score    FATHMM_pred RadialSVM_score RadialSVM_pred  LR_score    LR_pred VEST3_score CADD_raw  "
                + "CADD_phred  GERP++_RS   phyloP46way_placental   phyloP100way_vertebrate SiPhy_29way_logOdds";
        String[] titles = original.split("\\s+");
        String reString = generateSedRegex(titles, "2015-S00011-SNP-Filter.vcf.avinput.anno.hg19_multianno.txt");
        System.out.println(reString + " > testResult.json");
    }
}
