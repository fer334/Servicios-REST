CREATE TABLE public.movil
(
  identificador integer NOT NULL,
  tipo character varying(1000),
  CONSTRAINT pk_movil PRIMARY KEY (identificador)
);


CREATE TABLE public.ubicacion
(
    id integer NOT NULL DEFAULT nextval('ubicacion_id_seq'::regclass),
    latitud character varying COLLATE pg_catalog."default",
    longitud character varying COLLATE pg_catalog."default",
    date timestamp without time zone,
    movil integer,
    CONSTRAINT ubicacion_pkey PRIMARY KEY (id),
    CONSTRAINT ubicacion_movil_fkey FOREIGN KEY (movil)
        REFERENCES public.movil (identificador) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.ubicacion
    OWNER to postgres;