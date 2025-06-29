PGDMP  $    &    	            }         	   northcars    17.5    17.5     6           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            7           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            8           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            9           1262    16388 	   northcars    DATABASE     �   CREATE DATABASE northcars WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE northcars;
                     postgres    false            �            1259    24600    pessoa    TABLE     �   CREATE TABLE public.pessoa (
    cpf character(11) NOT NULL,
    nome character varying(100),
    telefone character(15),
    idade integer
);
    DROP TABLE public.pessoa;
       public         heap r       postgres    false            �            1259    24613    administrador    TABLE     ]   CREATE TABLE public.administrador (
    idadmin integer NOT NULL
)
INHERITS (public.pessoa);
 !   DROP TABLE public.administrador;
       public         heap r       postgres    false    218            �            1259    24612    administrador_idadmin_seq    SEQUENCE     �   CREATE SEQUENCE public.administrador_idadmin_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.administrador_idadmin_seq;
       public               postgres    false    222            :           0    0    administrador_idadmin_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.administrador_idadmin_seq OWNED BY public.administrador.idadmin;
          public               postgres    false    221            �            1259    24583    carro    TABLE     )  CREATE TABLE public.carro (
    car_modelo text NOT NULL,
    car_ano integer NOT NULL,
    car_passageiross integer NOT NULL,
    car_capacidade real NOT NULL,
    car_litros_tanque real NOT NULL,
    car_disponivel text NOT NULL,
    car_idcarro integer NOT NULL,
    car_placa text NOT NULL
);
    DROP TABLE public.carro;
       public         heap r       postgres    false            �            1259    24606    usuario    TABLE     Y   CREATE TABLE public.usuario (
    idcliente integer NOT NULL
)
INHERITS (public.pessoa);
    DROP TABLE public.usuario;
       public         heap r       postgres    false    218            �            1259    24605    usuario_idcliente_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_idcliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.usuario_idcliente_seq;
       public               postgres    false    220            ;           0    0    usuario_idcliente_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.usuario_idcliente_seq OWNED BY public.usuario.idcliente;
          public               postgres    false    219            �           2604    24616    administrador idadmin    DEFAULT     ~   ALTER TABLE ONLY public.administrador ALTER COLUMN idadmin SET DEFAULT nextval('public.administrador_idadmin_seq'::regclass);
 D   ALTER TABLE public.administrador ALTER COLUMN idadmin DROP DEFAULT;
       public               postgres    false    221    222    222            �           2604    24609    usuario idcliente    DEFAULT     v   ALTER TABLE ONLY public.usuario ALTER COLUMN idcliente SET DEFAULT nextval('public.usuario_idcliente_seq'::regclass);
 @   ALTER TABLE public.usuario ALTER COLUMN idcliente DROP DEFAULT;
       public               postgres    false    219    220    220            3          0    24613    administrador 
   TABLE DATA           L   COPY public.administrador (cpf, nome, telefone, idade, idadmin) FROM stdin;
    public               postgres    false    222   ;       .          0    24583    carro 
   TABLE DATA           �   COPY public.carro (car_modelo, car_ano, car_passageiross, car_capacidade, car_litros_tanque, car_disponivel, car_idcarro, car_placa) FROM stdin;
    public               postgres    false    217   X       /          0    24600    pessoa 
   TABLE DATA           <   COPY public.pessoa (cpf, nome, telefone, idade) FROM stdin;
    public               postgres    false    218   u       1          0    24606    usuario 
   TABLE DATA           H   COPY public.usuario (cpf, nome, telefone, idade, idcliente) FROM stdin;
    public               postgres    false    220   �       <           0    0    administrador_idadmin_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.administrador_idadmin_seq', 1, false);
          public               postgres    false    221            =           0    0    usuario_idcliente_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.usuario_idcliente_seq', 1, false);
          public               postgres    false    219            �           2606    24618     administrador administrador_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.administrador
    ADD CONSTRAINT administrador_pkey PRIMARY KEY (idadmin);
 J   ALTER TABLE ONLY public.administrador DROP CONSTRAINT administrador_pkey;
       public                 postgres    false    222            �           2606    32769    carro carro_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.carro
    ADD CONSTRAINT carro_pkey PRIMARY KEY (car_idcarro);
 :   ALTER TABLE ONLY public.carro DROP CONSTRAINT carro_pkey;
       public                 postgres    false    217            �           2606    24604    pessoa pessoa_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (cpf);
 <   ALTER TABLE ONLY public.pessoa DROP CONSTRAINT pessoa_pkey;
       public                 postgres    false    218            �           2606    24611    usuario usuario_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (idcliente);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public                 postgres    false    220            3      x������ � �      .      x������ � �      /      x������ � �      1      x������ � �     