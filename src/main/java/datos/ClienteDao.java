package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDao {

    private String sql = "";
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private Cliente cliente = null;

    public List<Cliente> listar() {

        List<Cliente> clientes = new ArrayList<>();
        sql = "select * from cliente";
        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
                cliente = new Cliente(id, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }
        return clientes;

    }

    public Cliente buscar(Cliente cliente) {

        sql = "select * from cliente where id=?";
        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cliente.getId());
            rs = pst.executeQuery();

//            rs.absolute(1);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setEmail(email);
                cliente.setTelefono(telefono);
                cliente.setSaldo(saldo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }

        return cliente;
    }

    public int insert(Cliente cliente) {
        sql = "insert into cliente(nombre,apellido,email,telefono,saldo) values(?,?,?,?,?)";

        int row = 0;
        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefono());
            pst.setDouble(5, cliente.getSaldo());

            row = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

//            Conexion.close(rs);
//            Conexion.close(pst);
            Conexion.close(conn);
        }
        return row;
    }

    public int update(Cliente cliente) {
        sql = "update cliente set nombre=?,apellido=?,email=?,telefono=?,saldo=? where id=?";

        int row = 0;
        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefono());
            pst.setDouble(5, cliente.getSaldo());
            pst.setInt(6, cliente.getId());

            row = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

//            Conexion.close(rs);
            //          Conexion.close(pst);
            Conexion.close(conn);
        }
        return row;
    }

    public int delete(Cliente cliente) {
        sql = "delete from cliente where id=?";

        int row = 0;
        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(sql);

            pst.setInt(1, cliente.getId());

            row = pst.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            //  Conexion.close(rs);
            // Conexion.close(pst);
            Conexion.close(conn);
        }
        return row;
    }

}
