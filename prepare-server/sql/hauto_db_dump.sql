--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: automobile; Type: TABLE; Schema: public; Owner: test_user
--

CREATE TABLE automobile (
    auto_id bigint NOT NULL,
    brand character varying(255),
    model character varying(255),
    human_id bigint NOT NULL
);


ALTER TABLE automobile OWNER TO test_user;

--
-- Name: automobile_auto_id_seq; Type: SEQUENCE; Schema: public; Owner: test_user
--

CREATE SEQUENCE automobile_auto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE automobile_auto_id_seq OWNER TO test_user;

--
-- Name: automobile_auto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test_user
--

ALTER SEQUENCE automobile_auto_id_seq OWNED BY automobile.auto_id;


--
-- Name: city; Type: TABLE; Schema: public; Owner: test_user
--

CREATE TABLE city (
    city_id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE city OWNER TO test_user;

--
-- Name: city_city_id_seq; Type: SEQUENCE; Schema: public; Owner: test_user
--

CREATE SEQUENCE city_city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE city_city_id_seq OWNER TO test_user;

--
-- Name: city_city_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test_user
--

ALTER SEQUENCE city_city_id_seq OWNED BY city.city_id;


--
-- Name: human; Type: TABLE; Schema: public; Owner: test_user
--

CREATE TABLE human (
    human_id bigint NOT NULL,
    firstname character varying(255),
    lastname character varying(255),
    middlename character varying(255),
    city_id bigint
);


ALTER TABLE human OWNER TO test_user;

--
-- Name: human_human_id_seq; Type: SEQUENCE; Schema: public; Owner: test_user
--

CREATE SEQUENCE human_human_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE human_human_id_seq OWNER TO test_user;

--
-- Name: human_human_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: test_user
--

ALTER SEQUENCE human_human_id_seq OWNED BY human.human_id;


--
-- Name: auto_id; Type: DEFAULT; Schema: public; Owner: test_user
--

ALTER TABLE ONLY automobile ALTER COLUMN auto_id SET DEFAULT nextval('automobile_auto_id_seq'::regclass);


--
-- Name: city_id; Type: DEFAULT; Schema: public; Owner: test_user
--

ALTER TABLE ONLY city ALTER COLUMN city_id SET DEFAULT nextval('city_city_id_seq'::regclass);


--
-- Name: human_id; Type: DEFAULT; Schema: public; Owner: test_user
--

ALTER TABLE ONLY human ALTER COLUMN human_id SET DEFAULT nextval('human_human_id_seq'::regclass);


--
-- Data for Name: automobile; Type: TABLE DATA; Schema: public; Owner: test_user
--

COPY automobile (auto_id, brand, model, human_id) FROM stdin;
1	Volkswagen	Golf-6	1
2	Lada	Vesta	1
3	Lada	Niva	2
4	Lada	Priora	2
5	Kia	Sorento	3
6	Kia	Rio	4
7	Toyta	Rav4	5
8	Toyta	Prius	6
9	Toyta	Land Cruiser	7
10	Toyta	Tundra	8
11	Kia	Cerato	9
12	Renualt	Coleos	10
\.


--
-- Name: automobile_auto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test_user
--

SELECT pg_catalog.setval('automobile_auto_id_seq', 12, true);


--
-- Data for Name: city; Type: TABLE DATA; Schema: public; Owner: test_user
--

COPY city (city_id, name) FROM stdin;
1	Пермь
2	Москва
3	Самара
4	Екатеринбург
5	Нижний Новгород
\.


--
-- Name: city_city_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test_user
--

SELECT pg_catalog.setval('city_city_id_seq', 5, true);


--
-- Data for Name: human; Type: TABLE DATA; Schema: public; Owner: test_user
--

COPY human (human_id, firstname, lastname, middlename, city_id) FROM stdin;
1	Иван	Васильев	Петрович	1
2	Андрей	Сидоров	Алексеевич	5
3	Роман	Никулин	Александрович	2
4	Борис	Григорьев	Миронович	4
5	Валерий	Богданов	Наумович	2
6	Георгий	Егоров	Оскарович	1
7	Денис	Тимофеев	Петрович	1
8	Елисей	Филиппов	Святославович	1
9	Зигфрид	Козлов	Филиппович	3
10	Максим	Сорокин	Яковлевич	3
\.


--
-- Name: human_human_id_seq; Type: SEQUENCE SET; Schema: public; Owner: test_user
--

SELECT pg_catalog.setval('human_human_id_seq', 10, true);


--
-- Name: automobile_pkey; Type: CONSTRAINT; Schema: public; Owner: test_user
--

ALTER TABLE ONLY automobile
    ADD CONSTRAINT automobile_pkey PRIMARY KEY (auto_id);


--
-- Name: city_pkey; Type: CONSTRAINT; Schema: public; Owner: test_user
--

ALTER TABLE ONLY city
    ADD CONSTRAINT city_pkey PRIMARY KEY (city_id);


--
-- Name: human_pkey; Type: CONSTRAINT; Schema: public; Owner: test_user
--

ALTER TABLE ONLY human
    ADD CONSTRAINT human_pkey PRIMARY KEY (human_id);


--
-- Name: fk_94w8tq9nv4a4mdpxoybwo24wd; Type: FK CONSTRAINT; Schema: public; Owner: test_user
--

ALTER TABLE ONLY human
    ADD CONSTRAINT fk_94w8tq9nv4a4mdpxoybwo24wd FOREIGN KEY (city_id) REFERENCES city(city_id);


--
-- Name: fk_qcq1vtnh026spacack9c3cuoc; Type: FK CONSTRAINT; Schema: public; Owner: test_user
--

ALTER TABLE ONLY automobile
    ADD CONSTRAINT fk_qcq1vtnh026spacack9c3cuoc FOREIGN KEY (human_id) REFERENCES human(human_id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--