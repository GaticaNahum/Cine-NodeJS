const express = require('express');
const pool = require('../database');
const router = express.Router();

router.get('/', async(req, res) => {
    let listCategoria = await pool.query('SELECT * FROM categoria');
    res.json({
        status: 200,
        message: "Se ha listado correctamente",
        listCategoria: listCategoria
    });
});

router.get('/:id', async(req, res) => {
    const { id } = req.params;
    let categoria = await pool.query('Select * from categoria where id = ?', [id]);
    res.json({
        status: 200,
        message: "Se ha obtenido correctamente",
        categoria: categoria
    });
});

router.post('/create', async(req, res) => {
    const { nombre } = req.body;

    const categoria = {
        nombre
    };

    await pool.query('INSERT INTO categoria set ?', [categoria]);
    res.json({
        status: 200,
        message: "Se ha registrado correctamente",
        categoria: categoria
    });
});

router.post('/update/:id', async(req, res) => {
    const { id } = req.params;
    const { nombre } = req.body;

    const categoria = {
        nombre
    };

    await pool.query('UPDATE categoria set ? where id = ?', [categoria, id]);

    res.json({
        status: 200,
        message: "Se ha actualizado correctamente",
        categoria: categoria
    });
});


router.post('/delete/:id', async(req, res) => {
    const { id } = req.params;

    await pool.query('delete from categoria where id = ?', [id]);
    res.json({
        status: 200,
        message: "Se ha eliminado correctamente"
    });
});


module.exports = router;