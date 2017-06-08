<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<ul class="collapsible active" data-collapsible="accordion">


	
	<!-- Affichage des parties en cours -->
	<c:forEach items="${ listeParties }" var="partie">
		<li>
			<div class="collapsible-header">Partie #${ partie.id }</div>
			<div class="collapsible-body raw">
			
				<!-- Affiche l'username du joueurA -->
				<div>Joueur A : ${ partie.joueurA.username }</div>

				<!-- Bouton permettant de rejoindre une partie -->
				<c:if test="${ (partie.joueurB == null) && ( userConnecte != partie.joueurA) }">
					<div class="float right">
						<form method="POST" action="newJoueur">
							<button class="btn waves-effect waves-light" type="submit">Rejoindre
								la partie</button>
							<input type="hidden" value=${ partie.id}
						name="partie_id_new_joueur" />
						</form>
					</div>
				</c:if>

				<!-- Affiche l'username du joueurB -->
				<c:if test="${ partie.joueurB == null }">
					<div>Joueur B : en attente</div>
				</c:if>
				<c:if test="${ partie.joueurB != null }">
					<div>Joueur B : ${ partie.joueurB.username }</div>
				</c:if>

			</div>


		</li>
	</c:forEach>
</ul>



<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	<form method="POST" action="parties/newPartie">
		<button class="btn-floating btn-large waves-effect waves-light red"
			type="submit">
			<i class="material-icons">add</i>
		</button>
	</form>
</div>