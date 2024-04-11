CREATE OR REPLACE FUNCTION remove_accent(text) RETURNS text AS $$
BEGIN
  RETURN translate($1, 'áàãâäéèẽêëíìĩîïóòõôöúùũûüçÁÀÃÂÄÉÈẼÊËÍÌĨÎÏÓÒÕÔÖÚÙŨÛÜÇ', 'aaaaaeeeeiiiiiooooouuuuucAAAAAEEEEIIIIIOOOOOUUUUC');
END;
$$ LANGUAGE plpgsql IMMUTABLE;
