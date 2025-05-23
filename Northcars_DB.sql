PGDMP  5                    }         	   northcars    17.5    17.5     0           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            1           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            2           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            3           1262    16388 	   northcars    DATABASE     �   CREATE DATABASE northcars WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE northcars;
                     postgres    false            �            1259    16408    Administrador    TABLE     O   CREATE TABLE public."Administrador" (
    "Adm_id_admin" integer[] NOT NULL
);
 #   DROP TABLE public."Administrador";
       public         heap r       postgres    false            �            1259    16394    Carro    TABLE     2  CREATE TABLE public."Carro" (
    "Car_placa" "char"[] NOT NULL,
    "Car_modelo" "char"[] NOT NULL,
    "Car_disponivel" boolean[] NOT NULL,
    "Car_ano" integer[] NOT NULL,
    "Car_npassageiros" integer[] NOT NULL,
    "Car_capacidade" numeric[] NOT NULL,
    "Car_tanque_litros" numeric[] NOT NULL
);
    DROP TABLE public."Carro";
       public         heap r       postgres    false            �            1259    16389    Pessoa    TABLE     �   CREATE TABLE public."Pessoa" (
    "Pes_cpf" "char" NOT NULL,
    "Pes_nome" "char" NOT NULL,
    "Pes_telefone" "char" NOT NULL,
    "Pes_idade" integer NOT NULL
);
    DROP TABLE public."Pessoa";
       public         heap r       postgres    false            �            1259    16401    Usuario    TABLE     K   CREATE TABLE public."Usuario" (
    "Usu_id_cliente" integer[] NOT NULL
);
    DROP TABLE public."Usuario";
       public         heap r       postgres    false            -          0    16408    Administrador 
   TABLE DATA           9   COPY public."Administrador" ("Adm_id_admin") FROM stdin;
    public               postgres    false    220   "       +          0    16394    Carro 
   TABLE DATA           �   COPY public."Carro" ("Car_placa", "Car_modelo", "Car_disponivel", "Car_ano", "Car_npassageiros", "Car_capacidade", "Car_tanque_litros") FROM stdin;
    public               postgres    false    218   ?       *          0    16389    Pessoa 
   TABLE DATA           V   COPY public."Pessoa" ("Pes_cpf", "Pes_nome", "Pes_telefone", "Pes_idade") FROM stdin;
    public               postgres    false    217   \       ,          0    16401    Usuario 
   TABLE DATA           5   COPY public."Usuario" ("Usu_id_cliente") FROM stdin;
    public               postgres    false    219   y       �           2606    16414     Administrador Administrador_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY public."Administrador"
    ADD CONSTRAINT "Administrador_pkey" PRIMARY KEY ("Adm_id_admin");
 N   ALTER TABLE ONLY public."Administrador" DROP CONSTRAINT "Administrador_pkey";
       public                 postgres    false    220            �           2606    16400    Carro Carro_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public."Carro"
    ADD CONSTRAINT "Carro_pkey" PRIMARY KEY ("Car_placa");
 >   ALTER TABLE ONLY public."Carro" DROP CONSTRAINT "Carro_pkey";
       public                 postgres    false    218            �           2606    16393    Pessoa Pessoa_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public."Pessoa"
    ADD CONSTRAINT "Pessoa_pkey" PRIMARY KEY ("Pes_cpf");
 @   ALTER TABLE ONLY public."Pessoa" DROP CONSTRAINT "Pessoa_pkey";
       public                 postgres    false    217            �           2606    16407    Usuario Usuario_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT "Usuario_pkey" PRIMARY KEY ("Usu_id_cliente");
 B   ALTER TABLE ONLY public."Usuario" DROP CONSTRAINT "Usuario_pkey";
       public                 postgres    false    219            -      x������ � �      +      x������ � �      *      x������ � �      ,      x������ � �     