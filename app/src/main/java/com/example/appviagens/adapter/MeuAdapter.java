package com.example.appviagens.adapter;


import android.content.Context;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appviagens.R;

import java.util.List;


import static com.example.appviagens.util.DevolveDrawableUtil.devolveDrawable;
import static com.example.appviagens.util.FormataDiasUtil.formataDias;
import static com.example.appviagens.util.FormataPrecoUtil.formataPeco;

public class MeuAdapter extends BaseAdapter {

    /**
     * declaração das variaveis
     */
    private final List<Pacotes> pacotes;
    private final Context context;

    TextView local;
    TextView preco;
    TextView dias;
    ImageView imagem;

    /**
     * declaração do construtor
     * que irá receber da chamadora (Main) uma lista
     * com os itens que irão aparecer no list view
     */
    public MeuAdapter(List<Pacotes> pacotes, Context context){

        this.pacotes = pacotes;
        this.context = context;
    }

    /**
     * retorna q quantidade de itens que serão exibidos
     * @return
     */
    @Override
    public int getCount() {

        return pacotes.size();
    }

    /**
     * devolve um pacote, um item da lista
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {

        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**irá implementar o layout criado de item
     * o metodo será chamado cada vez que um novo item
     * da lista for criado (mostrado)
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("will", "getView: ");

        /**
         * realiza o inflate do layout a partir do contexto recebido pelo construtor, e indcando qual view será inflada
         * como não será inflado imediatamente, recebe false e a view será retornada
         */
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_view_pacote,parent, false);

        /**Para realizar o processo de binding é necessario recuperar os itens
         * do pacote e selecionar qual deles será exibido. Nesse caso é criada
         * uma variavel do tipo Pacotes que receberá a fererencia para um dos
         * objetos da classe Pacotes de acordo com o indice do ArrayList
         */
        Pacotes itemAtual = this.pacotes.get(position);

        /**
         * chamada dos metodos que implementam o adapter
         */
        mostraLocal(viewCriada, itemAtual);
        mostraPreco(viewCriada, itemAtual);
        mostraDias(viewCriada, itemAtual);
        mostraImagem(viewCriada, itemAtual);

        /**
         * retorna a view que foi criada
         */
        return viewCriada;
    }

    private void mostraImagem(View viewCriada, Pacotes itemAtual) {
        /**
         * Referencia o elemento da view criada no adapter com
         * o elemento de view do modelo xml
         */
        imagem = viewCriada.findViewById(R.id.iv_item_lista_imageView);

        /**
         * recebe um drawable que será mostrado da image view
         */
        Drawable drawImagePacote = devolveDrawable(itemAtual.getImagem(), context);

        /**
         * seta a imagem
         */
        imagem.setImageDrawable(drawImagePacote);
    }

    private void mostraDias(View viewCriada, Pacotes itemAtual) {
        /**
         * Referencia o elemento da view criada no adapter com
         * o elemento de view do modelo xml
         */
        dias = viewCriada.findViewById(R.id.tv_item_lista_dias);

        /**
         * recebe o texto de dias formatado para  o modo que queremos
         */
        String ndias = formataDias(itemAtual.getDias());

        /**
         * Iprime da view o texto do numero de dias
         */
        dias.setText(ndias);
    }

    private void mostraPreco(View viewCriada, Pacotes itemAtual) {
        /**
         * Referencia o elemento da view criada no adapter com
         * o elemento de view do modelo xml
         */
        preco = viewCriada.findViewById(R.id.tv_item_lista_preco);

        /**
         * Chama o metodo formaraPreco da classe util e
         * devolve o texto formatado para preço
         */
        String precoF = formataPeco(itemAtual.getPreco());

        /**
         * Escreve na view o valor do pacote
         */
        preco.setText(precoF);
    }


    private void mostraLocal(View viewCriada, Pacotes itemAtual) {

        /**
         * Referencia o elemento da view criada no adapter com
         * o elemento de view do modelo xml
         */
        local = viewCriada.findViewById(R.id.tv_item_lista_pacote);
        /**
         * faz o binding do elemento do objeto itemAtual
         * com o elemento da view
         */
        local.setText(itemAtual.getLocal());
    }
}
