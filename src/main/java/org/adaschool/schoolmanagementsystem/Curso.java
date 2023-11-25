package org.adaschool.schoolmanagementsystem;

public class Curso {
    package org.adaschool.schoolmanagementsystem;

    public class Curso {
        private int id;
        private String name;
        private String descripcion;
        private int numeroCreditos;
        private int version;

        private static int ultimoId;

        public Curso(String name, String descripcion, int numeroCreditos, int version) {
            this.id = ++ultimoId;
            this.name = name;
            this.descripcion = descripcion;
            this.numeroCreditos = numeroCreditos;
            this.version = version;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public int getNumeroCreditos() {
            return numeroCreditos;
        }

        public void setNumeroCreditos(int numeroCreditos) {
            this.numeroCreditos = numeroCreditos;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        @Override
        public String toString() {
            return "Curso{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", descripcion='" + descripcion + '\'' +
                    ", numeroCreditos=" + numeroCreditos +
                    ", version=" + version +
                    '}';
        }
    }
}
