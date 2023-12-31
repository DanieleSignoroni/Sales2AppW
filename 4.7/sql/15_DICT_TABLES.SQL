  # DICT_TABLES 
      INSERT INTO <SCH>DICT_TABLES (NAME, DESCRIPTION, TAB_SPACE_NAME, SCHEMA_NAME, SHORT_NAME) VALUES ('YLEGAME_AGENTE_UTENTE', 'Legame (Agente-Utente) - Sales 2 Ap', null, 'SOFTRE', 'YLEGAME');
  # DICT_COLUMNS 
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YLEGAME_AGENTE_UTENTE', 'ID_AZIENDA', 'ID_AZIENDA', 'IdAzienda', 'Azienda', 1, 1, '1', null, null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YLEGAME_AGENTE_UTENTE', 'STATO', 'STATO', 'Stato', 'Stato', 2, 0, '1', null, null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YLEGAME_AGENTE_UTENTE', 'R_UTENTE_CRZ', 'R_UTENTE_C', 'UserId', 'Utente creazione', 3, 0, '0', null, null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YLEGAME_AGENTE_UTENTE', 'TIMESTAMP_CRZ', 'TIMESTAMP_', 'Timestamp', 'Timestamp creazione', 4, 0, '2', 'CURRENT TIMESTAMP', null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YLEGAME_AGENTE_UTENTE', 'R_UTENTE_AGG', 'R_UTENTE_A', 'UserId', 'Utente ultima modifica', 5, 0, '0', null, null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YLEGAME_AGENTE_UTENTE', 'TIMESTAMP_AGG', 'TIMESTAMP0', 'Timestamp', 'Timestamp ultima modifica', 6, 0, '2', 'CURRENT TIMESTAMP', null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YLEGAME_AGENTE_UTENTE', 'R_AGENTE', 'R_AGENTE', 'IdAgente', 'Agente', 7, 2, '1', null, null);
      INSERT INTO <SCH>DICT_COLUMNS (TAB_NAME, NAME, SHORT_NAME, REFERENCE, DESCRIPTION, SEQUENCE, KEY_SEQUENCE, NULL_TYPE, DEFAULT_VALUE, REMARKS) VALUES ('YLEGAME_AGENTE_UTENTE', 'R_UTENTE', 'R_UTENTE', 'Stringa40', 'Hash utente s2app', 8, 0, '0', null, null);
  # DICT_INDEXES 
      INSERT INTO <SCH>DICT_INDEXES (NAME, SHORT_NAME, DESCRIPTION, TAB_NAME, UNIQUENESS) VALUES ('YLEGAME_AGENTE_I01', 'YLEGAM_I01', 'Primary Key', 'YLEGAME_AGENTE_UTENTE', 'Y');
  # DICT_INDEX_COLS 
      INSERT INTO <SCH>DICT_INDEX_COLS (TAB_NAME, INDEX_NAME, NAME, SEQUENCE, VERSE) VALUES ('YLEGAME_AGENTE_UTENTE', 'YLEGAME_AGENTE_I01', 'ID_AZIENDA', 1, 'A');
      INSERT INTO <SCH>DICT_INDEX_COLS (TAB_NAME, INDEX_NAME, NAME, SEQUENCE, VERSE) VALUES ('YLEGAME_AGENTE_UTENTE', 'YLEGAME_AGENTE_I01', 'R_AGENTE', 2, 'A');
  # DICT_CONSTRAINTS 
      INSERT INTO <SCH>DICT_CONSTRAINTS (NAME, TAB_NAME, DELETE_RULE, REF_TABLE) VALUES ('Agente_1057987313', 'YLEGAME_AGENTE_UTENTE', '0', 'AGENTI');
      INSERT INTO <SCH>DICT_CONSTRAINTS (NAME, TAB_NAME, DELETE_RULE, REF_TABLE) VALUES ('Azienda_430336339', 'YLEGAME_AGENTE_UTENTE', '0', 'AZIENDE_ESTESE');
      INSERT INTO <SCH>DICT_CONSTRAINTS (NAME, TAB_NAME, DELETE_RULE, REF_TABLE) VALUES ('Utente_43822418', 'YLEGAME_AGENTE_UTENTE', '0', 'YUTENTI_SALES_2_APP');
  # DICT_CONSTR_COLS 
      INSERT INTO <SCH>DICT_CONSTR_COLS (TAB_NAME, CONSTR_NAME, NAME, SEQUENCE, ID) VALUES ('YLEGAME_AGENTE_UTENTE', 'Agente_1057987313', 'ID_AZIENDA', 1, <NUM><DICT_CONSTR_COLS>);
      INSERT INTO <SCH>DICT_CONSTR_COLS (TAB_NAME, CONSTR_NAME, NAME, SEQUENCE, ID) VALUES ('YLEGAME_AGENTE_UTENTE', 'Agente_1057987313', 'R_AGENTE', 2, <NUM><DICT_CONSTR_COLS>);
      INSERT INTO <SCH>DICT_CONSTR_COLS (TAB_NAME, CONSTR_NAME, NAME, SEQUENCE, ID) VALUES ('YLEGAME_AGENTE_UTENTE', 'Azienda_430336339', 'ID_AZIENDA', 1, <NUM><DICT_CONSTR_COLS>);
      INSERT INTO <SCH>DICT_CONSTR_COLS (TAB_NAME, CONSTR_NAME, NAME, SEQUENCE, ID) VALUES ('YLEGAME_AGENTE_UTENTE', 'Utente_43822418', 'R_UTENTE', 1, <NUM><DICT_CONSTR_COLS>);

