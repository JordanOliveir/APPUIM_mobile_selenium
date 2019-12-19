package Suporte;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Randomicos {

    public String dataAtual() {
        Date data = new Date();
        String dataAtual = DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
      return dataAtual;
    }

    public String numerosAleatorios(int tamanho){
        String AB = "123456789";
        SecureRandom rnd = new SecureRandom();
        int len = tamanho;
        StringBuilder sb = new StringBuilder(len);
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        sb.toString();
        String valor = String.valueOf(sb);

        return valor;
    }
    
    public String gerarBoleto(String banco, String valor){
        String codBarra = "";
        String fatorVencimento;
        int soma = 0;
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int m = 0;
        
        String dataVencimento = dataAtual();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataBase;
        Date vencimento;
        try {
            dataBase = sdf.parse("07/10/1997");
            vencimento = sdf.parse(dataVencimento);
        } catch (java.text.ParseException x) {
            return codBarra;
        }
    
        long diferencaMS = vencimento.getTime() - dataBase.getTime();
        long diferencaDias = diferencaMS / 86400000;
    
        fatorVencimento = String.valueOf(diferencaDias);
        System.out.println(fatorVencimento);
        a = Integer.valueOf(banco.substring(0, 1));
        b = Integer.valueOf(banco.substring(1, 2));
        c = Integer.valueOf(banco.substring(2, 3));
        d = Integer.valueOf(fatorVencimento.substring(0, 1));
        e = Integer.valueOf(fatorVencimento.substring(1, 2));
        f = Integer.valueOf(fatorVencimento.substring(2, 3));
        g = Integer.valueOf(fatorVencimento.substring(3, 4));
        h = Integer.valueOf(valor.substring(0, 1));
        i = Integer.valueOf(valor.substring(1, 2));
        j = Integer.valueOf(valor.substring(2, 3));
        k = Integer.valueOf(valor.substring(3, 4));
        l = Integer.valueOf(valor.substring(4, 5));
        m = Integer.valueOf(valor.substring(5, 6));
    
        int[] barras = {a, b, c, 9, 0, d, e, f, g, 0, 0, 0, 0, h, i, j, k, l, m, 0, 0, 0, 0, 0, 0, 1, 2, 4, 3, 2, 4, 5, 0, 0, 1, 1, 2, 4, 4, 6, 2, 2, 1, 7};
        int[] fatores = {4, 3, 2, 9, 0, 8, 7, 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    
        //CONTA PARA PEGAR O DIGITO VERIFICADOR E SUBSTITUIR NA POSIÇÃO 4 DO CODIGO DE BARRAS
        for (int y = 0; y < fatores.length; y++) {
            soma += barras[y] * fatores[y];
        }
    
        int mod = soma % 11;
        int resultado = 11 - mod;
    
        barras[4] = resultado;
    
        //PEGA O NOVO CODIGO DE BARRAS MODIFICADO
        for(Integer item : barras){
            codBarra += String.valueOf(item);
        }
    
        System.out.println(codBarra);
    
        return codBarra;
    }

    public String caracteresAleatorios(int tamanho){
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom rnd = new SecureRandom();
        int len = tamanho; //tamanho de caracteres
        StringBuilder sb = new StringBuilder(len);
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        sb.toString();
        String aux = String.valueOf(sb);

        return aux;
    }

    public String letrasAleatorias(int tamanho){
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom rnd = new SecureRandom();
        int len = tamanho; //tamanho de caracteres
        StringBuilder sb = new StringBuilder(len);
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        sb.toString();
        String aux = String.valueOf(sb);

        return aux;
    }

    public String calendario(){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

        Calendar calendario = Calendar.getInstance();
        String data = sdf.format(calendario.getTime());

        return data;
    }

    public String somarDia(int dias){
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

        Calendar calendario = Calendar.getInstance();

        calendario.add(Calendar.DAY_OF_MONTH, dias);
        String data = sdf.format(calendario.getTime());

        return data;
    }
}