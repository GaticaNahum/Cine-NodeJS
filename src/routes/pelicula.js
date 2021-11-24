const express = require('express');
const pool = require('../database');
const router = express.Router();

router.get('/', async(req, res) => {
    let listPeliculas = await pool.query('SELECT * FROM pelicula');
    res.json({
        status: 200,
        message: "Se ha listado correctamente",
        listPeliculas: listPeliculas
    });
});

router.get('/:id', async(req, res) => {
    const { id } = req.params;
    let pelicula = await pool.query('Select * from pelicula where id = ?', [id]);
    res.json({
        status: 200,
        message: "Se ha obtenido correctamente",
        pelicula: pelicula
    });
});



router.post('/create', async(req, res) => {
    const { titulo, descripcion, sinopsis, rating, categoria } = req.body;

    const dateNow = Date.now();

    const fechaRegistro = new Date(dateNow);
    const estado = 1;
    const pelicula = {
        titulo,
        descripcion,
        sinopsis,
        rating,
        fechaRegistro,
        estado,
        categoria
    };

    await pool.query('INSERT INTO pelicula set ?', [pelicula]);
    res.json({
        status: 200,
        message: "Se ha registrado correctamente",
        pelicula: pelicula
    });
});

router.post('/update/:id', async(req, res) => {
    const { id } = req.params;
    const { titulo, descripcion, sinopsis, rating, categoria } = req.body;

    const dateNow = Date.now();

    const fechaUpdate = new Date(dateNow);
    const pelicula = {
        titulo,
        descripcion,
        sinopsis,
        rating,
        fechaUpdate,
        categoria
    };

    await pool.query('UPDATE pelicula set ? where id = ?', [pelicula, id]);

    res.json({
        status: 200,
        message: "Se ha actualizado correctamente",
        pelicula: pelicula
    });
});

router.post('/delete/:id', async(req, res) => {
    const { id } = req.params;

    await pool.query('UPDATE pelicula set estado = 0 where id = ?', [id]);
    res.json({
        status: 200,
        message: "Se ha eliminado correctamente"
    });
});

module.exports = router;