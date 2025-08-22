package model;

public class Imovel {
        private int id;
        private String endereco;
        private String tipo;
        private int quartos;
        private int banheiros;
        private double area;
        private double valor_aluguel;
        private boolean disponivel;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getTipo(){
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public int getQuartos() {
            return quartos;
        }

        public void setQuartos(int quartos) {
            this.quartos = quartos;
        }

        public int getBanheiros() {
            return banheiros;
        }

        public void setBanheiros(int banheiros) {
            this.banheiros = banheiros;
        }

        public double getArea() {
        return area;
    }

        public void setArea(double area) {
        this.area = area;
    }

        public double getValor_aluguel() {
        return valor_aluguel;
    }

        public void setValor_aluguel(int valor_aluguel) {
        this.valor_aluguel = valor_aluguel;
    }

        public boolean isDisponivel() {
        return disponivel;
    }

        public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    }



