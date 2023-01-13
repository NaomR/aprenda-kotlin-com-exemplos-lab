// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(var nome:String, val email:String,val senha:String, val nivelConhecimento: Nivel)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String,val nivelDificuldade: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        inscritos.add(usuario)
    }
    
    fun getInscritosOrdenadosPorNivelConhecimento(): List<Usuario> {
        return inscritos.sortedBy {it.nivelConhecimento}
    }
    
    fun usuarioEstaInscrito(usuario:Usuario):Boolean {
        return usuario in inscritos
    }
    
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    val usuario1 = Usuario("Ricardo","ricardo99@bol.com.br","cachorroquente",Nivel.INTERMEDIARIO)
    val usuario2 = Usuario("Paulo","paulogomez@hotmail.com.br","meucachorro",Nivel.BASICO)
    val usuario3 = Usuario("Ana","anabeatriz75@gmail.com.br","bialinda123",Nivel.DIFICIL)

    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    val conteudo01 = ConteudoEducacional("Introdução á Programação")
    val conteudo02 = ConteudoEducacional("Programação Orientada a Objetos",75)
    val conteudo03 = ConteudoEducacional("Meu primeiro Aplicativo")
    
    val formacao1 = Formacao("$conteudo01",Nivel.BASICO,listOf(conteudo01,conteudo03))
    val formacao2 = Formacao("$conteudo02",Nivel.INTERMEDIARIO,listOf(conteudo02))
    
    formacao1.matricular(usuario2)
    formacao1.matricular(usuario1)
    formacao2.matricular(usuario3)
    
    
    
    println("O Usuário ${usuario1.nome} foi Inscrito em: ${formacao1.nome} - Nível:${formacao1.nivelDificuldade}")
    println("O Usuário ${usuario3.nome} foi Inscrito em: ${formacao2.nome} - Nível:${formacao2.nivelDificuldade}")
}
