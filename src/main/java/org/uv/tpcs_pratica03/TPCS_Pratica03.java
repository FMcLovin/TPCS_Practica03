/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.tpcs_pratica03;

import java.util.Date;
import org.uv.tpcs_pratica03.dao.ClienteDao;
import org.uv.tpcs_pratica03.dao.DetalleVentaDao;
import org.uv.tpcs_pratica03.dao.ProductoDao;
import org.uv.tpcs_pratica03.dao.VentaDao;
import org.uv.tpcs_pratica03.modelo.Cliente;
import org.uv.tpcs_pratica03.modelo.DetalleVenta;
import org.uv.tpcs_pratica03.modelo.Producto;
import org.uv.tpcs_pratica03.modelo.Venta;

/**
 *
 * @author Usuario
 */
public class TPCS_Pratica03 {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente();
        cliente.setNombre("Sobas");
        cliente.setRfc("123123asdad");
        
        ClienteDao cd = new ClienteDao();
        cd.save(cliente);
        
        cliente.setNombre("Soplastian");
        cd.update(cliente);
        
        ProductoDao pd = new ProductoDao();
        Producto producto = pd.get(1);
        
        Venta venta = new Venta();
        venta.setFecha(new Date());
        venta.setId_cliente(cliente.getId_cliente());
        venta.setTotal(producto.getPrecio());
        
        VentaDao vd = new VentaDao();
        vd.save(venta);
        
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setCantidad(1);
        detalleVenta.setId_producto(producto.getId_producto());
        detalleVenta.setId_venta(venta.getId_venta());
        detalleVenta.setDescripcion("hola");
        detalleVenta.setPrecio(producto.getPrecio());
        
        DetalleVentaDao dvd = new DetalleVentaDao();
        dvd.save(detalleVenta);
        
    }
}
