import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class DropboxAPIExample {
    private static final String ACCESS_TOKEN = "sl.u.AGFtDIPIcdwI9mlY69R0y_EXcDhwK7wHRdl9id6RITv2NaKdIjap2_5BKak-Zq_enrSRezIF56B-sxf8qnll-hYFIS3PwWUq6I2Zm7MNcjAgWv0cweRi62SlHlB_-gNRMXChbcHJWI_w8jUwZn5ENhAre9jqPNauKOvop0e_fr7dMtJyWcGWy9CTJHEpl8RoRpF7vQIAWJv4Hv6csv-BR41kPyy_Srxs92nYYNv5TUF7ePuz5xEaAQHUo_r2mKON60xx61Hav_EsHLrumGEW7rv_Sqjdrk_2U232Se66SBMVq4Sg8wb9OcWPl9RHDzmLxVws6JMMoAjkLzx1kUGPmPP5ggUpS_QWkDKvxPR_XX_V3vmUo4eM-opEcFheqowvPMxGZP6LDsBpDtPJLFV7XbH-DapdWR1pPa9cejZETJA5kE5DGvfl3oIF7YFO_gpik8uQXuZEELur-U8xCAu5vq4fxOure0eK4FlaxLIxi09Sl91QKVXPxmZsbzzpO3mCaGg-szJc1t8rO_hGELII1oRa4PqA2bz_52iXJUe8Fmt5qs2gk569faqZADgzplQdz75uAyTNIgA0W9bs4PJFRyc5obMbK69W52pNFVuzqGb7pSwXuKcWlkVdpyxhyRinj3PgQwCoZB6LQDcQlL5Im8ty2ZWZMwVVEufrAyS-o94eJrRV1gbs8TyFKwD9fkIBCWE5deylevEay3bMklWEP5psm6XKH0SM9aKVPjb0KnlLxbqPzHPD5pM8CF3UOcrFyv0rxXSm6c0IzOR4RIp5gAug1ET2nhjy-ufFElLZ8uWqNC91L8LsUhMS7NjjGZY4gdcRXv4u_-DBHHlfi9WmzzCX67vgUK9tRe6tFYSNTCdlCT2pD_-Nlzosf_unf87dr7SkGhd6-l2mUWIaARBlwrxbrUhMZ2P3UGpX6yyZPVAWqLFVvpyBLNOTpRBEaez7y7Gl_vm7sSDPPmry3pYyIO_KyFej9w3wIIGjA9ioN00EUOgZFKnGrn7sAsS_IsJHSvRfvus59s5ROXouwpqjBnwIY1R8fnyjuFDtO34QV_f9RHfpB8XTSKAbhUBSUQPVprPnqTDVm1X1Gdvd-p20urf23RUS-JUtMh4myaw6CDsh_g";

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://api.dropboxapi.com/2/team/members/list_v2");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + ACCESS_TOKEN);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonInput = "{\"limit\": 5}";
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        String responseLine;
        StringBuilder response = new StringBuilder();
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }

        System.out.println(response.toString());
    }
}
