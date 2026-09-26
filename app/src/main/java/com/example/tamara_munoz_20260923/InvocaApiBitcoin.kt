package com.example.tamara_munoz_20260923

import android.os.AsyncTask
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class InvocaApiBitcoin(val callback: (List<String>) -> Unit) : AsyncTask<Void, Void, List<String>>() {

    override fun doInBackground(vararg params: Void?): List<String> {
        val listaValores = mutableListOf<String>()
        try {
            val url = URL("https://mindicador.cl/api/bitcoin")
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.connect()

            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    response.append(line)
                }
                reader.close()

                val jsonObject = JSONObject(response.toString())
                if (jsonObject.has("serie")) {
                    val serieArray = jsonObject.getJSONArray("serie")
                    for (i in 0 until serieArray.length()) {
                        val item = serieArray.getJSONObject(i)
                        val fecha = item.getString("fecha").substring(0, 10)
                        val valor = item.getDouble("valor")
                        listaValores.add("Fecha: $fecha | Valor: \$$valor")
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return listaValores
    }

    override fun onPostExecute(result: List<String>) {
        super.onPostExecute(result)
        callback(result)
    }
}