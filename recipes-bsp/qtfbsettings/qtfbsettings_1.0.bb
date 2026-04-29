SUMMARY = "QT5 default platform config installer"
DESCRIPTION = "Recipe created by A.Sigov"
LICENSE = "CLOSED"

inherit allarch

FILESEXTRAPATHS:prepend := ":${THISDIR}/${PN}:"

SRC_URI = " \
    file://qtplatform.conf \
    file://qtplatform.sh"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d
    install -d ${D}${sysconfdir}/systemd/system.conf.d/

    install -m 0666 ${WORKDIR}/qtplatform.sh   ${D}${sysconfdir}/profile.d/qtplatform.sh
    install -m 0666 ${WORKDIR}/qtplatform.conf ${D}${sysconfdir}/systemd/system.conf.d/qtplatform.conf
}

FILES:${PN} = " \
    ${sysconfdir}/profile.d/qtplatform.sh \
    ${sysconfdir}/systemd/system.conf.d/qtplatform.conf \
"