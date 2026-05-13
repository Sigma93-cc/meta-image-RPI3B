DESCRIPTION = "SW Update hwrevision file generator"
LICENSE = "CLOSED"

HW_REVISION ?= "1.0"

do_install(){
    install -d ${D}${sysconfdir}
    echo " ${MACHINE} ${HW_REVISION}" > ${D}${sysconfdir}/hwrevision
}

FILES:${PN} = "${sysconfdir}/hwrevision"