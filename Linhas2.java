public class Linhas2 {
    public static void main (String[] args) {
        int [] gavetas= new int[4];
        String arte= "0,9,5,9\n8,0,0,8\n9,4,3,4\n2,2,2,1\n7,0,7,4\n6,4,2,0\n0,9,2,9\n3,4,1,4\n0,0,8,8\n5,5,8,2\n";
        String numero="", nova="";
        int [] tamanho = new int[arte.length()];
        int contador = 0;

        for (int p = 0; p<arte.length();p++) {
            if (arte.charAt(p)==',') {
                tamanho[contador] = Integer.parseInt(nova);
                nova = "";
                contador++;
            }
            else if (arte.charAt(p)=='\n') {
                tamanho[contador] = Integer.parseInt(nova);
                nova = "";
                contador++;
            }
            else {
                nova = nova + arte.charAt(p);
            }
        }
        int tam = maior_vetor(tamanho);
        int [][] matriz= new int[tam+1][tam+1];

        int p=0;

        for(int i=0; i<arte.length(); i++){
            if(arte.charAt(i)==','){
                numero="";
                p++;

            }
            else if(arte.charAt(i)=='\n'){
                gavetas[p]=Integer.parseInt(numero);
                p=0;
                numero="";

                //linhas
                if(gavetas[0]==gavetas[2]){
                    int maior= Maior(gavetas[1], gavetas[3]);
                    int Menor= Menor(gavetas[1], gavetas[3]);
                    int lin = gavetas[0];

                    for(int a=Menor; a<=maior; a++){
                        matriz[lin][a]= matriz[lin][a]+1;
                    }
                }
                //colunas
                else if(gavetas[1]==gavetas[3]){
                    int maior= Maior(gavetas[0], gavetas[2]);
                    int Menor= Menor(gavetas[0], gavetas[2]);
                    int col=gavetas[1];

                    for(int a=Menor; a<=maior; a++){
                        matriz[a][col]=matriz[a][col] +1;
                    }
                }
                //diagonais
                else {
                    int dl = 1, dc = 1;
                    int li = gavetas[0], lf = gavetas[2], ci = gavetas[1], cf = gavetas[3];

                    if (li>lf) dl = -1;
                    if (ci>cf) dc = -1;

                    while (li!=lf && ci!=cf) {
                        matriz[li][ci] = matriz[li][ci] + 1;
                        li = li + dl;
                        ci = ci + dc;
                    }
                }
                //mesmo racicionio que acima, mas codigo mais extenso logo em seguida:
                /*else {
                    //esquerda
                    int y = gavetas[1];
                    if (gavetas[1]>gavetas[3]) {
                        if (gavetas[0]>gavetas[2]) {//pra cima
                            for (int x=gavetas[0];x>=gavetas[2];x--) {
                                matriz[x][y] = matriz[x][y] + 1;
                                y--;
                            }
                        } else { //pra baixo
                            for (int x=gavetas[0];x<=gavetas[2];x++) {
                                matriz[x][y] = matriz[x][y] + 1;
                                y--;
                            }
                        }
                    }
                    //direita
                    else {//gavetas[1]<gavetas[3]
                        if (gavetas[0]>gavetas[2]) {//pra cima
                            for (int x=gavetas[0];x>=gavetas[2];x--) {
                                matriz[x][y] = matriz[x][y] + 1;
                                y++;
                            }
                        } else {//pra baixo
                            for (int x=gavetas[0];x<=gavetas[2];x++) {
                                matriz[x][y] = matriz[x][y] + 1;
                                y++;
                            }
                        }
                    }
                }*/

            }
            else {
                numero = numero + arte.charAt(i);
                gavetas[p]=Integer.parseInt(numero);
            }
        }

        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++){
                System.out.printf("%d ",matriz[i][j]);
            }
            System.out.println(" ");
        }
    }
    public static int Menor(int a, int b){
        int aux=a;

        if(b<aux){
            aux=b;
        }
        return aux;
    }
    public static int Maior(int a, int b){
        int aux=a;

        if(b>aux){
            aux=b;
        }
        return aux;
    }
    public static int maior_vetor (int[] vetor) {
        int aux = vetor[0];
        for (int i=1;i<vetor.length;i++){
            if (vetor[i]>aux) aux=vetor[i];
        }
        return aux;
    }
}
