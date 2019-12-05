/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefx;
import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Gson {
		public boolean gravarScore(int[] lista) throws IOException {
			FileWriter writer = new FileWriter("ScorePoint.json");
			GsonBuilder builder = new GsonBuilder();
		    com.google.gson.Gson gson = builder.create();
		    writer.write(gson.toJson(lista));
		    writer.close();
			return false;
		}
                public boolean gravarNome(String[] lista) throws IOException {
			FileWriter writer = new FileWriter("ScoreNome.json");
			GsonBuilder builder = new GsonBuilder();
		    com.google.gson.Gson gson = builder.create();
		    writer.write(gson.toJson(lista));
		    writer.close();
			return false;
		}
		public int[] lerScore() throws IOException {
                    
		    GsonBuilder builder = new GsonBuilder();
		    com.google.gson.Gson gson = builder.create();
		    builder = new GsonBuilder();
		    gson = builder.create();
		    BufferedReader bufferedReader = new BufferedReader(new FileReader("ScorePoint.json"));

		    String linha =bufferedReader.readLine();
		    
		    linha =linha.replace("[", "");
		    linha = linha.replace("]", "");
		    String[] vetor = linha.split(",");
		    int[] vetorInt = new int[vetor.length];
		    for (int i = 0; i < vetor.length; i++) {
				vetorInt[i] = Integer.parseInt(vetor[i]);
			}
		    return vetorInt;
		}
               public String[] lerNome() throws IOException {
                    
		    GsonBuilder builder = new GsonBuilder();
		    com.google.gson.Gson gson = builder.create();
		    builder = new GsonBuilder();
		    gson = builder.create();
		    BufferedReader bufferedReader = new BufferedReader(new FileReader("ScoreNome.json"));

		    String linha =bufferedReader.readLine();
		    
		    linha =linha.replace("[", "");
		    linha = linha.replace("]", "");
                    linha = linha.replace("\"", "");
                    System.out.println(linha);
		    String[] vetor = linha.split(",");
		    String[] vetorInt = new String[vetor.length];
		    for (int i = 0; i < vetor.length; i++) {
				vetorInt[i] = (vetor[i]);
			}
		    return vetorInt;
		}
               
               public boolean verificandoVetor(int[] score, String[] nome,String nomeString, int pontos){
                    for (int i = 0; i < score.length; i++) {
                        if (pontos >= score[i]) {
                            for (int j = score.length-1; j > i; j--) {
                                score[j] = score[j-1];
                                nome[j] = nome[j-1];
                                
                            }
                            score[i] = pontos;
                            nome[i] = nomeString;
                            break;
                        }
                       
                   }
                    try {
                        gravarNome(nome);
                        gravarScore(score);
                    } catch (IOException ex) {
                        Logger.getLogger(Gson.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                   return true;
               }
               

}
